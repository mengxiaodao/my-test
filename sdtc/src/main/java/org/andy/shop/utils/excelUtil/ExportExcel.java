package org.andy.shop.utils.excelUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2015/6/2.
 */
public class ExportExcel {

    public  static void exportFile(Map<String, List<List<String>>> fileMap, String filePath, HttpServletResponse response,
                            HttpServletRequest request, String fileName) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        HSSFDataFormat format = workbook.createDataFormat();
        cellStyle.setDataFormat(format.getFormat("@"));
        Set<String> sheetSet = fileMap.keySet();
        Object[] sheetName = sheetSet.toArray();
        HSSFSheet sheet=null;
        for (int k = 0; k < sheetName.length; k++) {
            sheet = workbook.createSheet();
            workbook.setSheetName(k, sheetName[k].toString());
            List<List<String>> fileData = fileMap.get(sheetName[k]);
            for (int i = 0; i < fileData.size(); i++) {
                HSSFRow row = sheet.createRow(i);
                sheet.setDefaultColumnWidth(18);
                List<String> fileBody = fileData.get(i);
                for (int j = 0; j < fileBody.size(); j++) {
                    HSSFCell cell = row.createCell(j);
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue(fileBody.get(j));
                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                }
            }
        }

        try {
            String name = fileName + ".xls";
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;" + encodingFileName(name, request));
            ServletOutputStream fos = response.getOutputStream();
            workbook.write(fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String encodingFileName(String filename, HttpServletRequest request) throws UnsupportedEncodingException {

        String userAgent = request.getHeader("User-Agent");
        if (StringUtils.isEmpty(userAgent)) {
            return "filename=" + URLEncoder.encode(filename, "UTF8");
        } else if (userAgent.indexOf("Trident") != -1) {
            return "filename=" + URLEncoder.encode(filename, "UTF8");
        } else if (userAgent.indexOf("MSIE") != -1) {
            return "filename=" + URLEncoder.encode(filename, "UTF8");
        } else if (userAgent.indexOf("Opera") != -1) {
            return "filename*=UTF-8''" + URLEncoder.encode(filename, "UTF8");
        } else {
            return "filename=\"" + new String(filename.getBytes("UTF-8"), "ISO8859-1") + "\"";
        }
    }

    /**
     * @author yiming
     * @param sheetName sheet单页名称
     * @param fileData 待处理数据
     * @return
     */
    public static Map<String, List<List<String>>> executeSheet(String sheetName, List<List<String>> fileData) {

        Map<String, List<List<String>>> fileMap = new HashMap<>();
        Integer total = fileData.size();
        Integer forTotal = total/50000 + 1;
        for(int i = 0; i < forTotal; i++) {
            Integer last = (forTotal-1) != i ? (i+1)*50000 : total;
            List<List<String>> executes = fileData.subList(i*50000, last);
            if(i != 0) {
                sheetName = sheetName + i;
            }
            fileMap.put(sheetName, executes);
        }
        return fileMap;
    }
}

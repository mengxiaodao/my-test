package org.andy.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andy.shop.exception.BusinessException;
import org.andy.shop.model.Message;
import org.andy.shop.model.dto.MessageDto;
import org.andy.shop.model.vo.MessageVo;
import org.andy.shop.service.MessageService;
import org.andy.shop.service.redisUtil.RedisCacheUtil;
import org.andy.shop.utils.DateUtil;
import org.andy.shop.utils.Pagination;
import org.andy.shop.utils.Result;
import org.andy.shop.utils.excelUtil.ExportExcel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/msgManage")
public class MessageController {
	@Resource
	private MessageService messageService;
	@Resource
	private RedisCacheUtil redisCacheUtil;

	/**
	 * 展示资源分页列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/pageInit.do")
	public ModelAndView  pageInit(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();  
		mav.setViewName("/message/messageList"); //返回的文件名 
		return mav;
	}
	
	/**
	 * 蓝马乱码乱码
	 * @Description: 资源管理获取分页列表啦
	 * @param: @param messageDto
	 * @param: @return      
	 * @return: Pagination<MessageVo>
	 * @author: mc
	 */
	@RequestMapping(value="/getMsgList.do")
	@ResponseBody
	public Pagination<MessageVo> getMsgList(MessageDto messageDto) {
		Pagination<MessageVo> messPagination = messageService.getMessagesByDto(messageDto);
		return messPagination;
	}
	/**
	 * 插入资源
	 * @param message
	 * @return
	 */
	@RequestMapping(value="/insertMsg.do")
	@ResponseBody
	public Result insertMsg(Message message) {
		Result result = new Result();
		try {
			messageService.insertMsg(message);
		} catch (Exception e) {
			e.printStackTrace();
			result.set("插入失败", false);
		}
		result.set("插入成功", true);
		return result;
	}
	/**
	 * 删除资源by id
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/deleteMsgById.do")
	@ResponseBody
	public Result deleteMsgById(Long id) {
		Result result = new Result();
		try {
			messageService.deleteMsgById(id);
			result.set("删除成功", true);
		} catch (BusinessException be) {
			result.set(be.getMessage(), false);
		}
		return result;
	}
	
	/**
	 * 统计导出条数
	 * @param messageDto
	 * @return
	 */
	@RequestMapping(value="/getMsgExportCount.do")
	@ResponseBody
	public Result getMsgExportCount(MessageDto messageDto){
		 Result result = new Result(Boolean.FALSE);
		 int count = 0;
		 count = messageService.getMsgExportCount(messageDto);
		 result.setStatus(Boolean.TRUE);
		 result.setData(count);
		 return result;
	}
	
	@RequestMapping(value ="/exportMsgList.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Result exportMsgList(MessageDto messageDto,HttpServletRequest request, HttpServletResponse response){
		 Result result = new Result(Boolean.FALSE);
		 try {
			String[] columnNames = {"资源id","资源名称","资源发布日期","资源类型","资源售价","所属省份id","所属城市id", "创建时间"};
			 //excel
			 Map<String, List<List<String >>> fileMap = new HashMap<>();
			 //文件头
			 List<String> fileHead = new ArrayList<>();
			 for(String columnName : columnNames){
			     fileHead.add(columnName);
			 }
			 List<List<String>> fileData = new ArrayList<>();
			 fileData.add(fileHead);
			 //获取要导出的列表数据
			 Pagination<MessageVo> pg = this.getMsgList(messageDto);
			 //账单列表
			 List<MessageVo> messageVos = pg.getRows();
			 for(MessageVo detailVO : messageVos){
			     List<String> fileBody = new ArrayList<>();
			     fileBody.add(String.valueOf(detailVO.getId())); //资源id
			     fileBody.add(detailVO.getMsgName()); // 资源名称
			     // 资源发布时间
			     if (DateUtil.converDateToStringDate(detailVO.getPublishTime()).equals("1970-01-01")) {
			         fileBody.add("");
			     } else {
			         fileBody.add(DateUtil.converDateToStringDate(detailVO.getPublishTime()));
			     }
			     // 资源类别，1广告大牌，2电视多媒体，3LED显示屏	
			     if (detailVO.getMsgType() == 1) {
			         fileBody.add("广告大牌");
			     } else if (detailVO.getMsgType() == 2){
			         fileBody.add("电视多媒体");
			     }else{
			    	 fileBody.add("LED显示屏");
			     }
			     fileBody.add(String.valueOf(detailVO.getMsgPrice())); //资源售价
			     if (detailVO.getProvinceId() == null|| detailVO.getProvinceId()==0) {//省id
			         fileBody.add("");
			     } else {
			         fileBody.add(String.valueOf(detailVO.getProvinceId()));
			     }
			     if (detailVO.getCityId() == null|| detailVO.getCityId()==0) {//市id
			         fileBody.add("");
			     } else {
			         fileBody.add(String.valueOf(detailVO.getCityId()));
			     }
			     // 资源发布时间
			     if (DateUtil.converDateToStringDateTime(detailVO.getCreateTime()).equals("1970-01-01 00:00:00")) {
			         fileBody.add("");
			     } else {
			         fileBody.add(DateUtil.converDateToStringDateTime(detailVO.getCreateTime()));
			     }
			     
			     fileData.add(fileBody);
			 }
			 String fileName = "资源信息表导出";
			 fileMap.put(fileName, fileData);
			 String filePath = request.getSession().getServletContext().getRealPath("/") + "assets" + "/excel" +  fileName +".xls";
			 ExportExcel.exportFile(fileMap, filePath, response, request, fileName);
			 result.setStatus(Boolean.TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			result.set("资源导出失败", Boolean.FALSE);;
		}
		 return result;
	}

}

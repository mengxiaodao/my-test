package org.andy.shop.utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;
public class DateConverter implements Converter<String,Date>{
	//定义系统全局类型转换器，前端json里的时间字符串转javabean的date类型
    @Override
    public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            return sdf.parse(source);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}


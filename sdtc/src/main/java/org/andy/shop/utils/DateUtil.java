package org.andy.shop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
     * Description ： 日期转Java时间类型yyyy-MM-dd hh:mm:ss<br>
     * yangwb
     * @param date
     * @return
     * @since
     */
    public static Date convertDateToDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s = sdf.format(date);
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            return null;
        }
    }
}

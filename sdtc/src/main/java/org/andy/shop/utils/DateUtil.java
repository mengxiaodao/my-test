package org.andy.shop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
     * Description ： 日期转转化成字符串，精确到天yyyy-MM-dd
     * @param date
     * @return
     * @since
     */
	public static String converDateToStringDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.format(date);
        } catch (Exception e) {
            return null;
        }
    }
    
	/**
     * Description ： 日期转转化成字符串，精确到秒 yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     * @since
     */
	public static String converDateToStringDateTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return format.format(date);
        } catch (Exception e) {
            return null;
        }
    }
	
	/**
     * Description ： 日期转日期类型yyyy-MM-dd hh:mm:ss<br>
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

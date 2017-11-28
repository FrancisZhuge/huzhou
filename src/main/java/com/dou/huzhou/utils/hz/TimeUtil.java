package com.dou.huzhou.utils.hz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/26, 22:00
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class TimeUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(TimeUtil.class);
    /**
     * 将yyyyMMddhh装换为yyyy-MM-dd hh:mm:ss格式
     * @param before 转换之前的时间字符串
     * @return
     */
    public static String convertToStandard(String before){
        SimpleDateFormat sdfBefore = new SimpleDateFormat("yyyyMMddhh");
        SimpleDateFormat sdfAfter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        String after = null;
        try {
            date = sdfBefore.parse(before);
            after = sdfAfter.format(date);
        } catch (ParseException e) {
            LOGGER.error("convertToStandard failed. ");
        }
        return after;
    }

    /**
     * 返回整点的时间
     * 输入0,表示当天0点
     * 输入1,表示当天1点
     * @return
     */
    public static String getTodayTimeByHour(int hour){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hour);
        Date date = new Date(cal.getTimeInMillis());
        String format = null;
        try {
            format = sdf.format(date);
        } catch (Exception e) {
            LOGGER.error("getTodayTimeByHour failed. ");
        }
        return format;
    }

    /**
     * 获取本月有多少天
     * @return
     */
    public static int getThisMonthDays(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int maximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return maximum;
    }

    /**
     * 根据指定的日期获得本年本月+指定的{day}组合的字符串为yyyy-MM-dd的类型
     * @param day
     * @return
     */
    public static String getTimeByDay(int day){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH,day);
        Date date = new Date(cal.getTimeInMillis());
        String format = null;
        try {
            format = sdf.format(date);
        } catch (Exception e) {
            LOGGER.error("getTimeByDay failed. ");
        }
        return format;
    }

    /**
     * 返回当月指定日期的指定时间的整点时间
     * @param day 指定日期，1表示1号
     * @param hour 指定时间，1 表示1点
     * @return
     */
    public static String getTimeByDayAndHour(int day, int hour){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Date date = null;
        cal.set(Calendar.DAY_OF_MONTH,day);
        cal.set(Calendar.HOUR_OF_DAY,hour);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        date = new Date(cal.getTimeInMillis());
        String format = null;
        try {
            format = sdf.format(date);
        } catch (Exception e) {
            LOGGER.error("getTimeByDayAndHour failed. ");
        }
        return format;
    }

    /**
     * 通过指定{year}{month}{day}来返回yyyy-MM-dd格式的时间字符串
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String getTimeByYearAndMonth(int year, int month, int day){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH,day);
        Date date = new Date(cal.getTimeInMillis());
        String format = null;
        try {
            format = sdf.format(date);
        } catch (Exception e) {
            LOGGER.error("getTimeByYearAndMonth failed. ");
        }
        return format;
    }

    /**
     * 获取今年是几几年
     * @return
     */
    public static int getCurrentYear(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    /**
     * 获取今年今月是几月
     * @return
     */
    public static int getCurrentMonth(){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH)+1;
        return month;
    }

    /**
     * 获取year年，month月对应月份的天数
     * @param year
     * @param month
     * @return
     */
    public static int getDaysByYearAndMonth(int year, int month){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, 1);
        cal.roll(Calendar.DATE, -1);
        int days = cal.get(Calendar.DATE);
        return days;
    }

}

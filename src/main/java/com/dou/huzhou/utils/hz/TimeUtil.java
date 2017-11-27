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
     * @param before
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
    public static String getTimeByHour(int i){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Date date = null;
        cal.set(Calendar.HOUR_OF_DAY, i);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        date = new Date(cal.getTimeInMillis());
        String format = null;
        try {
            format = sdf.format(date);
        } catch (Exception e) {
            LOGGER.error("getTimeByHour failed. ");
        }
        return format;
    }
}

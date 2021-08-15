package com.wgy.aup.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description 时间日期工具类
 * author wgy
 * version 2021/8/15 17:18:26
 */
public class DateUtils {


    /**
     * 获取当前时间
     * @return
     */
    public static Date getNowTime(){
        return new Date();
    }

    /**
     * 获取
     * @param time
     * @return
     */
    public static Date getAddParamTime(Long time){
        if (time == null){
            return new Date();
        }
        return new Date(new Date().getTime() + time);
    }

    /**
     * 返回yyyy-MM-dd日期格式
     * @param date
     * @return
     */
    public static String toDateStr(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    /**
     * 返回 yyyy-MM-dd HH:mm:ss日期格式
     * @param date
     * @return
     */
    public static String toDateFormatStr(Date date){
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sm.format(date);
    }

}

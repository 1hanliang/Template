package com.hebrf.template.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by LYB on 2016/10/25.
 * (今天上午开了一个技术部的会,一共说了3件事:
 *      1.service层[业务逻辑]包含dao(dal).jar[本地调用];
 *      dao.jar包含(api和service[单表增删改查]),这也做的目的是解决内网带宽过大
 *      2.分库分表的事,最终达成由mycat解决
 *      3.开发后台需要的文档[1.表结构设计,借口设计]
 * )
 *
 */
public class TimeUtils {
    public static String format(long time, String format) {
        return new SimpleDateFormat(format).format(time);
    }

    /**
     * 毫秒制时间转成24小时制时间
     * @param time
     * @return
     */
    public static int time2Day(long time) {
        return (int) (time / 1000 / 60 / 60 / 24);
    }

    public static String convertData2DataString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public static String convertMillisecond2DataString(long time) {
        return convertData2DataString(new Date(time));
    }


    private static int convertMillisecond2CalendarWeekInt(long time) {
        Date date = new Date(time);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int week = c.get(Calendar.DAY_OF_WEEK);
        return week;
    }


}

package com.hebrf.template.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by LYB on 2016/11/4.
 */
public class DateUtil {
    /**
     *
     * 获得系统时间.<br />
     *
     *
     * @return
     */
    public static String getNowTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = f.format(c.getTime());
        return nowTime;
    }

    /**
     *
     * 获得系统时间.<br />
     *
     *
     * @param format
     *            时间格式
     * @return
     */
    public static String getNowTime(String format) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        java.text.SimpleDateFormat f = new java.text.SimpleDateFormat(format);
        String nowTime = f.format(c.getTime());
        return nowTime;
    }

    /**
     *
     * 获得系统日期.<br />
     *
     *
     * @param format
     *            日期格式化
     * @return
     */
    public static String getNowDate(String format) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        java.text.SimpleDateFormat f = new java.text.SimpleDateFormat(format);
        String nowTime = f.format(c.getTime());
        return nowTime;
    }

    /**
     *
     * 获得系统日期.<br />
     *
     *
     * @return
     */
    public static String getNowDate() {
        java.util.Calendar c = java.util.Calendar.getInstance();
        java.text.SimpleDateFormat f = new java.text.SimpleDateFormat(
                "yyyy-MM-dd");
        String nowTime = f.format(c.getTime());
        return nowTime;
    }

    /**
     * 根据传入时间，往前推多少天
     *
     * @Title: getDateTimeForDate
     * @Description: String 转成Date
     * @param datetime
     * @return
     */
    public static String getBeforeDate(String datetime, int days) {
        java.text.SimpleDateFormat f = new java.text.SimpleDateFormat(
                "yyyy-MM-dd");
        try {
            Calendar c = java.util.Calendar.getInstance();
            Date date = f.parse(datetime);
            c.setTime(date);
            if (days >= 0) {
                c.add(Calendar.DAY_OF_MONTH, -days);
            } else {
                c.add(Calendar.DAY_OF_MONTH, days);
            }

            return f.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return datetime;
        }
    }

    /**
     * 计算两个时间内的相差的日期，例如：2013-12-30与2014-01-01,返回30、31、01
     *
     * @param start
     * @param end
     * @return
     */
    public static String[] getDiffDays(String start, String end) {
        SimpleDateFormat simpleFormate = new SimpleDateFormat("yyyy-MM-dd");
        @SuppressWarnings("unused")
        SimpleDateFormat sft = new SimpleDateFormat("dd");
        try {
            Date date1 = simpleFormate.parse(start);
            Date date2 = simpleFormate.parse(end);
            Calendar calendar = Calendar.getInstance();
            int count = (int) ((date2.getTime() - date1.getTime()) / 1000 / 60 / 60 / 24) + 1;
            // System.out.println(count);
            // 防止服务器时间超前
            if (count < 0) {
                return new String[] { "服务器时间错误" };
            }
            String[] days = new String[count];
            for (int i = 0; i < count; i++) {
                calendar.setTime(date1);
                calendar.add(Calendar.DAY_OF_MONTH, i);
                days[i] = simpleFormate.format(calendar.getTime());
                // System.out.println(days[i]);
            }
            return days;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算两个时间差，返回秒
     *
     * @param start
     * @param end
     * @return
     */
    public static long getTimeDifference(String start, String end) {
        long diff = 0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = format.parse(start);
            Date d2 = format.parse(end);
            diff = d2.getTime() - d1.getTime();
            diff = (long) (diff / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return diff;
    }

    /**
     *
     * @Title: getAfterDate
     * @Description:获得后一天日期
     * @return
     */
    public static String getAfterDate(String datetime) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        java.text.SimpleDateFormat f = new java.text.SimpleDateFormat(
                "yyyy-MM-dd");
        Date date = null;
        try {
            date = f.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);
        return f.format(c.getTime());

    }

    /**
     *
     * @Title: getBeforeDate
     * @Description:获得前一天日期
     * @return
     */
    public static String getBeforeDate(String datetime) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        java.text.SimpleDateFormat f = new java.text.SimpleDateFormat(
                "yyyy-MM-dd");
        Date date = null;
        try {
            date = f.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        return f.format(c.getTime());
    }

    /**
     *
     * @Title: getDateTimeForDate
     * @Description:传入一个Date ，格式化输出
     * @param date
     * @return
     */
    public static String getDateTimeForDate(Date date) {
        java.text.SimpleDateFormat f = new java.text.SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String nowTime = f.format(date);
        return nowTime;
    }

    /**
     *
     * @Title: getDateTimeForDate
     * @Description: String 转成Date
     * @param datetime
     * @return
     */
    public static Date getDateTimeForDate(String datetime) {
        java.text.SimpleDateFormat f = new java.text.SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        try {
            Date date = f.parse(datetime);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 格式话日期
     *
     * @param date
     * @param format
     * @return string
     */
    public static String getDateStr(Date date, String... format) {
        String formatStr = "";
        formatStr = format.length == 0 ? "yyyy-MM-dd" : format[0];
        SimpleDateFormat f = new SimpleDateFormat(formatStr);
        return f.format(date);
    }

    /**
     * 字符串格式化成日期
     *
     * @param dateStr
     * @param format
     * @return Date
     */
    public static Date getDateFromStr(String dateStr, String... format) {
        String formatStr = "";
        formatStr = format.length == 0 ? "yyyy-MM-dd" : format[0];
        SimpleDateFormat f = new SimpleDateFormat(formatStr);
        try {
            return f.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得以今天为基准的附近30天日期
     *
     * @return List<String>
     * */
    public static List<String> getListDate() {
        List<String> dateList = new ArrayList<String>();
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH) - 1;
        boolean flag = true;
        int num = 0;
        for (int i = 0; i < 30; i++) {
            int index = i;

            if (day - i == 0) {

                month = month - 1;
                if (month == 0) {
                    month = 12;
                }
                day = getDay(year, month);
                index = 0;
                num = i;
                flag = false;
            }

            if ((day - index) < 0) {
                day = getDay(year, month) + day - index;
                dateList.add(month + "." + day);

            } else {

                if (flag) {
                    dateList.add(month + "." + (day - index));

                } else {
                    if (num != i) {
                        dateList.add(month + "." + (day - index + num));
                    } else {
                        dateList.add(month + "." + (day - index));
                    }

                }

            }
        }

        return dateList;

    }

    /**
     * 获得某年某月有多少天
     *
     * @param year
     * @param month
     * */
    private static int getDay(int year, int month) {

        int dayNum = 0;
        switch (month) {

            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dayNum = 31;

                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dayNum = 30;
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    dayNum = 29;
                } else {
                    dayNum = 28;
                }
                break;
            default:
                break;
        }
        return dayNum;

    }

    public static int getAge(String start, String end) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateStart = null;
        Date dateEnd = null;
        try {
            dateStart = sdf.parse(start);
            dateEnd = sdf.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int count = (int) ((dateEnd.getTime() - dateStart.getTime()) / 1000
                / 60 / 60 / 24 / 365);
        return count;
    }

    /**
     * 获取日期所在月的最后一天
     *
     * @param date
     * @return
     */
    public static int getLastDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getDay(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1);
    }

    /**
     * 获取日期往后推一个月的日期
     *
     * @param date
     * @return
     */
    public static Date getNextMonthDate(Date date) {
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        c.setTime(date);
        c.set(Calendar.MONTH, month + 1);
        c.set(Calendar.DATE, c.get(Calendar.DATE) - 1);
        if (c.get(Calendar.MONTH) != month
                && (c.get(Calendar.MONTH) - month) % 2 == 0) {
            c.set(Calendar.MONTH, month + 1);
            c.set(Calendar.DATE, c.get(Calendar.YEAR) % 4 == 0 ? 29 : 28);
        }
        return c.getTime();
    }

    /**
     * 获取星期几
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static int getDayOfWeek(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        int num = calendar.get(Calendar.DAY_OF_WEEK);
        return num == 1 ? 7 : num - 1;
    }

}

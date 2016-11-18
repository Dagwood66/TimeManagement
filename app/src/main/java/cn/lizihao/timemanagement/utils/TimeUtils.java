package cn.lizihao.timemanagement.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


public class TimeUtils {
    private static final String TAG = TimeUtils.class.getName();
    public static final String FORMAT1 = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT2 = "yyyy-MM-dd";
    public static final String FORMAT3 = "HH:mm";
    public static final String FORMAT4 = "dd HH:mm:ss";
    private static GregorianCalendar gregorianCalendar = new GregorianCalendar();

    public static String getMonthBeforeDate() {
        gregorianCalendar.setTimeInMillis(System.currentTimeMillis());
        gregorianCalendar.add(Calendar.DAY_OF_MONTH, -31);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
        return simpleDateFormat.format(gregorianCalendar.getTimeInMillis());
    }


    public static String getCurrentTimeFormat(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(System.currentTimeMillis());
    }

    public static String getTimeFormat(long time, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(time);
    }

    public static long getPastWeek() {
        return System.currentTimeMillis() - 24 * 60 * 60 * 1000;
    }

    public static long getPastDay() {
        return System.currentTimeMillis() - 24 * 60 * 60 * 1000;
    }

    public static long parse(String timeFormat, String time) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(timeFormat);
        return (dateFormat.parse(time)).getTime();
    }

}

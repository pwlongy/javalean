package com.erjieduan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
/**
 *
 */
public class DateTest {
    public static void main(String[] args) {
        DateMethods.getDate();
        CalendarMethods.getDate();
        LocalDateTimeMethods.getDate();
    }
}

class DateMethods {
    public static void getDate() {
//      1. 获取当前系统时间
        Date date = new Date();
        System.out.println(date);
//      2. 格式化时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        System.out.println(time);
//      3. 将一段格式化的String转成对应的date
        String str = "2025-12-12 12:12:12";
        try {
            Date date1 = simpleDateFormat.parse(str);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


class CalendarMethods {
    public static void getDate() {
/**
 * 1. Calendar 是一个抽象类， 并且构造器是private的，
 * 2. 可以使用getInstance()方法获取实例
 * 3. 可以使用set()方法设置时间
 * 4. 可以使用get()方法获取时间
 * 5. 可以使用add()方法增加时间
 * 6. 可以使用roll()方法增加时间
 * 7. 可以使用format()方法格式化时间
 * 8. 可以使用parse()方法解析时间
 * 9. 可以使用compareTo()方法比较时间
 * 10. 可以使用getTime()方法获取时间戳
 * 11. 可以使用setTime()方法设置时间戳
 * 12. 可以使用getTimeInMillis()方法获取时间戳
 * 13. 可以使用setTimeInMillis()方法设置时间戳
 * 14. 可以使用getTimeZone()方法获取时区
 * 15. 可以使用setTimeZone()方法设置时区
 * 16. 可以使用getDisplayName()方法获取显示名称
 * 17. 可以使用getDisplayNames()方法获取显示名称
 * 18. 可以使用getFirstDayOfWeek()方法获取第一天
 *
 *
 * */
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println( "年 = " + calendar.get(Calendar.YEAR));
        System.out.println( "月 = " + (calendar.get(Calendar.MONTH) + 1));
        System.out.println( "日 =" + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println( "时 =" + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println( "分 =" + calendar.get(Calendar.MINUTE));
        System.out.println( "秒 =" + calendar.get(Calendar.SECOND));

    }
}

class LocalDateTimeMethods {
    public static void getDate() {
/**
 * 1. LocalDateTime 年月日时分秒
 * 2. LocalDate 年月日
 * 3. LocalTime 时分秒
 *
 * */

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
//      获取年月日时分秒
        System.out.println("年 = " + localDateTime.getYear());
        System.out.println("月 = " + localDateTime.getMonth());
        System.out.println("月 = " + localDateTime.getMonthValue());
        System.out.println("日 = " + localDateTime.getDayOfMonth());
        System.out.println("时 = " + localDateTime.getHour());
        System.out.println("分 = " + localDateTime.getMinute());
        System.out.println("秒 = " + localDateTime.getSecond());

//      提供 plus 和 minus方法可以对当前时间进行加或者减
        LocalDateTime localDateTime1 = localDateTime.plusDays(1);
        System.out.println(localDateTime1);
        LocalDateTime localDateTime2 = localDateTime.minusDays(1);
        System.out.println(localDateTime2);

        System.out.println("-----------localDate-------------");

        LocalDate localDate = LocalDate.now();
        System.out.println("年 = " + localDate.getYear());
        System.out.println("月 = " + localDate.getMonth());
        System.out.println("月 = " + localDate.getMonthValue());
        System.out.println("日 = " + localDate.getDayOfMonth());

        System.out.println("-----------localTime-------------");

        LocalTime localTime = LocalTime.now();
        System.out.println("时 = " + localTime.getHour());
        System.out.println("分 = " + localTime.getMinute());
        System.out.println("秒 = " + localTime.getSecond());


//      格式化时间
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = localDateTime.format(dateTimeFormatter);
        System.out.println(time);

        System.out.println("-----------解析时间-------------");

//      时间戳与Date的相互装换
        Instant instant = Instant.now();
        System.out.println(instant);
        Date date = Date.from(instant);
        System.out.println(date);
        Instant instant1 = date.toInstant();
        System.out.println(instant1);
    }
}

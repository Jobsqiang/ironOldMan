package com.qiangjiang.ironOldMan.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public DateUtils() {
    }

    public static String getCurrentDateTime() {
        return (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
    }

    public static long getCurrentDateTimeLong() {
        LocalDateTime dateTime = LocalDateTime.now();
        return (long)dateTime.getYear() * 10000000000L + (long)dateTime.getMonthValue() * 100000000L + (long)(dateTime.getDayOfMonth() * 1000000) + (long)(dateTime.getHour() * 10000) + (long)(dateTime.getMinute() * 100) + (long)dateTime.getSecond();
    }

    public static String formatCurrnetDate(String pattern) {
        return (new SimpleDateFormat(pattern)).format(new Date());
    }

    public static String getCurrentDateTime(int secord) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(13, secord);
        return (new SimpleDateFormat("yyyyMMddHHmmss")).format(calendar.getTime());
    }

    public static int getCurrentDateInt() {
        LocalDate dateTime = LocalDate.now();
        return dateTime.getYear() * 10000 + dateTime.getMonthValue() * 100 + dateTime.getDayOfMonth();
    }

}

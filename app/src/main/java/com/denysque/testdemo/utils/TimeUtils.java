package com.denysque.testdemo.utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtils {

    private TimeUtils() {
    }

    public static String convertTimeFromLong(long time) {
        Date date = new Date(time);
        Format format = new SimpleDateFormat("yyyy:MM:dd HH:mm", Locale.getDefault());
        return format.format(date);
    }
}

package com.denysque.testdemo.utils;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtils {

    private TimeUtils() {
    }

    public static String convertTimeFromLong(long time) {
        Date date = new Date(time * 1000L);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.getDefault());
        Log.d("TIME", "convertTimeFromLong: date long = " + time + " time =" + format.format(date));
        return format.format(date);
    }
}

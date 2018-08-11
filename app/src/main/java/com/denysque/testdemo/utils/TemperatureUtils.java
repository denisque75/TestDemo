package com.denysque.testdemo.utils;

public class TemperatureUtils {

    private TemperatureUtils() {
    }

    public static String convertToString(float numb) {
        int result = Math.round(numb);
        return String.valueOf(result);
    }

    public static String convertToHumidityString(float numb) {
        String result = convertToString(numb);
        return result + "%";
    }
}

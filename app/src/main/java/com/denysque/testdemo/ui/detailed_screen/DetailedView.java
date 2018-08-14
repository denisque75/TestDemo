package com.denysque.testdemo.ui.detailed_screen;

import com.arellomobile.mvp.MvpView;
import com.denysque.testdemo.core.models.Forecast;

public interface DetailedView extends MvpView {
    String TEMP = "TEMP";
    String MAX_TEMP = "MAX.TEMP";
    String MIN_TEMP = "MIN.TEMP";
    String HUMIDITY = "HUMIDITY";
    String CITY = "CITY";
    String MAIN_WEATHER_DESC = "MAIN.WEATHER.DESC";
    String TIME = "TIME";

    void displayForecast(Forecast forecast);
}

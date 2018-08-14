package com.denysque.testdemo.ui.detailed_screen;

import com.arellomobile.mvp.MvpView;
import com.denysque.testdemo.core.models.Forecast;

public interface DetailedView extends MvpView {
    String CITY_ID = "city.id";

    void displayForecast(Forecast forecast);
}

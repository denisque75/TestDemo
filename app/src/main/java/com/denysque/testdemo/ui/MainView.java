package com.denysque.testdemo.ui;

import com.arellomobile.mvp.MvpView;
import com.denysque.testdemo.core.pojo.Forecast;

import java.util.List;

public interface MainView extends MvpView {

    void showForecast(List<Forecast> forecasts);
}

package com.denysque.testdemo.ui;

import com.arellomobile.mvp.MvpView;
import com.denysque.testdemo.core.models.Forecast;


public interface MainView extends MvpView {

    void showForecast(Forecast forecasts);

    void openDetailedView(Forecast forecast);

    void showSearchDialog();

    void showMessage(String message);
}

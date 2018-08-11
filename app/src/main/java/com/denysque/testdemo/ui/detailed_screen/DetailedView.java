package com.denysque.testdemo.ui.detailed_screen;

import com.arellomobile.mvp.MvpView;
import com.denysque.testdemo.core.pojo.CityForecast;

import java.util.List;

public interface DetailedView extends MvpView {

    void displayForecast(List<CityForecast> forecast);
}

package com.denysque.testdemo.core.repository;

import com.denysque.testdemo.Stubs;

public class MainScreenRepositoryStub implements ForecastRepository {

    @Override
    public void loadForecastFromRepo(LoadForecastCallback callback) {
        callback.loadForecast(Stubs.getForecastList());
    }

    @Override
    public void loadCityForecastFromRepo(LoadCityForecastCallback callback) {
        callback.loadCityForecast(Stubs.getCityForecasts());
    }
}

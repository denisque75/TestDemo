package com.denysque.testdemo.core.repository;

import com.denysque.testdemo.core.models.Forecast;

public interface CityRepository {

    void loadCityForecastFromRepo(LoadCityForecastCallback callback);

    interface LoadCityForecastCallback {

        void loadCityForecast(Forecast forecast);
    }
}

package com.denysque.testdemo.core.repository;

import com.denysque.testdemo.core.models.Forecast;

public interface CityRepository {

    void loadCityForecastFromRepo(long cityId, LoadCityForecastCallback callback);

    interface LoadCityForecastCallback {

        void loadCityForecast(Forecast forecast);
    }
}

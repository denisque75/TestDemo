package com.denysque.testdemo.core.repository;

import com.denysque.testdemo.core.models.Forecast;

public interface ForecastRepository {

    void loadForecastsFromRepo(String city, LoadForecastCallback callback);

    void loadCityForecastFromRepo(LoadCityForecastCallback callback);

    interface LoadForecastCallback {

        void forecastResult(Forecast forecasts);
    }

    interface LoadCityForecastCallback {

        void loadCityForecast(Forecast forecast);
    }
}

package com.denysque.testdemo.core.repository;

import com.denysque.testdemo.core.models.Forecast;

public interface ForecastRepository {

    void loadForecastsFromRepo(String city, LoadForecastCallback callback);

    void loadForecastsFromRepo(long cityID, LoadForecastCallback callback);

    interface LoadForecastCallback {

        void forecastResult(Forecast forecasts);
    }

}

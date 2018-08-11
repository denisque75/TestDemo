package com.denysque.testdemo.core.repository;

import com.denysque.testdemo.core.pojo.CityForecast;
import com.denysque.testdemo.core.pojo.Forecast;

import java.util.List;

public interface ForecastRepository {

    void loadForecastFromRepo(LoadForecastCallback callback);

    void loadCityForecastFromRepo(LoadCityForecastCallback callback);

    interface LoadForecastCallback {

        void loadForecast(List<Forecast> forecasts);
    }

    interface LoadCityForecastCallback {

        void loadCityForecast(List<CityForecast> forecast);
    }
}

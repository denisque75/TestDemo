package com.denysque.testdemo.core.repository.db;

import com.denysque.testdemo.core.models.Forecast;

import java.util.List;

public interface DatabaseRepository {

    void saveForecast(Forecast forecast);

    List<Forecast> getAllForecasts();

    Forecast getForecastById(long id);

    List<String> getAllCities();

    void deleteForecast(Forecast item);
}

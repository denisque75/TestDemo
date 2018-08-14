package com.denysque.testdemo.core.repository;

import com.denysque.testdemo.core.models.Forecast;

import java.util.List;

public interface DatabaseRepository {

    void saveForecast(Forecast forecast);

    List<Forecast> getAllForecasts();

    Forecast getForecastById(int id);

    List<Long> getAllCitiesID();
}

package com.denysque.testdemo.core.repository.db.callbacks;

import com.denysque.testdemo.core.models.Forecast;
import com.denysque.testdemo.core.repository.db.CityDBCallback;

public interface DatabaseRepository {

    void saveForecast(Forecast forecast);

    void getAllForecasts(ForecastDBCallback callback);

    void getForecastById(long id, ForecastByIdCallback callback);

    void getAllCities(CityDBCallback callback);

    void deleteForecast(Forecast item);
}

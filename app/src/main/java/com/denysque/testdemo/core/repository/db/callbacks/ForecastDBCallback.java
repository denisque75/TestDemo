package com.denysque.testdemo.core.repository.db.callbacks;

import com.denysque.testdemo.core.models.Forecast;

import java.util.List;

public interface ForecastDBCallback {

    void forecastFromDB(List<Forecast> forecasts);
}

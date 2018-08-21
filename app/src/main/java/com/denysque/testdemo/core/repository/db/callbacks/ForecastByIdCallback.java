package com.denysque.testdemo.core.repository.db.callbacks;

import com.denysque.testdemo.core.models.Forecast;

public interface ForecastByIdCallback {

    void forecastById(Forecast forecast);
}

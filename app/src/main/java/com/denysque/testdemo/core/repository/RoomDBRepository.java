package com.denysque.testdemo.core.repository;

import com.denysque.testdemo.core.db.AppDatabase;
import com.denysque.testdemo.core.models.Forecast;

import java.util.List;

public class RoomDBRepository implements DatabaseRepository {
    private final AppDatabase database;

    public RoomDBRepository(AppDatabase database) {
        this.database = database;
    }

    @Override
    public void saveForecast(Forecast forecast) {
        database.getForecastDao().insert(forecast);
        database.getWeatherDao().insert(forecast.getWeatherList());
    }

    @Override
    public List<Forecast> getAllForecasts() {
        return null;
    }

    @Override
    public Forecast getForecastById(int id) {
        return null;
    }


}

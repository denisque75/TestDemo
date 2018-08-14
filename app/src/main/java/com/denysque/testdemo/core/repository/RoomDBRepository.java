package com.denysque.testdemo.core.repository;

import com.denysque.testdemo.core.db.AppDatabase;
import com.denysque.testdemo.core.models.Forecast;

import java.util.Calendar;
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
        List<Forecast> forecasts = database.getForecastDao().getAllForecasts();
        for (Forecast fc : forecasts) {
            fc.setWeatherList(database.getWeatherDao().getWeather(fc.getId(), Calendar.getInstance().getTime().getTime()));
            if (fc.getWeatherList() == null || fc.getWeatherList().isEmpty()) {
                fc.setWeatherList(database.getWeatherDao().getLastWeather(fc.getId()));
            }
        }
        return forecasts;
    }

    @Override
    public Forecast getForecastById(int id) {
        return null;
    }


}

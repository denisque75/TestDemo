package com.denysque.testdemo.core.repository.db;

import com.denysque.testdemo.core.db.AppDatabase;
import com.denysque.testdemo.core.models.Forecast;
import com.denysque.testdemo.core.repository.BaseDBRepository;

import java.util.Calendar;
import java.util.List;

public class RoomDBRepository extends BaseDBRepository implements DatabaseRepository {

    public RoomDBRepository(AppDatabase database) {
        super(database);
    }

    @Override
    public void saveForecast(Forecast forecast) {
        getDatabase().getForecastDao().insert(forecast);
        getDatabase().getWeatherDao().insert(forecast.getWeatherList());
    }

    @Override
    public List<Forecast> getAllForecasts() {
        List<Forecast> forecasts = getDatabase().getForecastDao().getAllForecasts();
        for (Forecast fc : forecasts) {
            fc.setWeatherList(getDatabase().getWeatherDao().getWeather(fc.getId(), Calendar.getInstance().getTime().getTime()));
            if (fc.getWeatherList() == null || fc.getWeatherList().isEmpty()) {
                fc.setWeatherList(getDatabase().getWeatherDao().getLastWeather(fc.getId()));
            }
        }
        return forecasts;
    }

    @Override
    public Forecast getForecastById(long id) {
        Forecast forecast = getDatabase().getForecastDao().getForecastCities(id);
        forecast.setWeatherList(getDatabase().getWeatherDao().getWeather(id, Calendar.getInstance().getTime().getTime()));
        return forecast;
    }

    @Override
    public List<String> getAllCities() {
        return getDatabase().getForecastDao().getAllCitiesId();
    }

    @Override
    public void deleteForecast(Forecast item) {
        getDatabase().getForecastDao().delete(item);
        getDatabase().getWeatherDao().deleteWeatherByCityId(item.getId());
    }
}

package com.denysque.testdemo.core.repository.db;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.denysque.testdemo.core.db.AppDatabase;
import com.denysque.testdemo.core.models.Forecast;
import com.denysque.testdemo.core.repository.db.callbacks.DatabaseRepository;
import com.denysque.testdemo.core.repository.db.callbacks.ForecastByIdCallback;
import com.denysque.testdemo.core.repository.db.callbacks.ForecastDBCallback;

import java.util.Calendar;
import java.util.List;

public class RoomDBRepository extends BaseDBRepository implements DatabaseRepository {
    private static final String TAG = "RoomDBRepository";

    private final Handler handler;

    public RoomDBRepository(AppDatabase database) {
        super(database);
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void saveForecast(final Forecast forecast) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getDatabase().getForecastDao().insert(forecast);
                getDatabase().getWeatherDao().insert(forecast.getWeatherList());
                Log.d(TAG, "saved forecast with city: " + forecast.getCity());
            }
        }).start();
    }

    @Override
    public void getAllForecasts(ForecastDBCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Forecast> forecasts = getDatabase().getForecastDao().getAllForecasts();
                for (Forecast fc : forecasts) {
                    fc.setWeatherList(getDatabase().getWeatherDao().getWeather(fc.getId(), Calendar.getInstance().getTime().getTime()));
                    if (fc.getWeatherList() == null || fc.getWeatherList().isEmpty()) {
                        fc.setWeatherList(getDatabase().getWeatherDao().getLastWeather(fc.getId()));
                    }
                }
                handler.post(() -> callback.forecastFromDB(forecasts));
                Log.d(TAG, "returned forecasts");
            }
        }).start();
    }

    @Override
    public void getForecastById(final long id, ForecastByIdCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Forecast forecast = getDatabase().getForecastDao().getForecastCities(id);
                forecast.setWeatherList(getDatabase().getWeatherDao().getWeather(id, Calendar.getInstance().getTime().getTime()));
                handler.post(() -> callback.forecastById(forecast));
                Log.d(TAG, "returned forecast by ID: " + forecast.getId());
            }
        }).start();

    }

    @Override
    public void getAllCities(CityDBCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> cities = getDatabase().getForecastDao().getAllCitiesId();

                handler.post(() -> callback.citiesFromDB(cities));
                Log.d(TAG, "returned all cities");
            }
        }).start();
    }

    @Override
    public void deleteForecast(final Forecast item) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getDatabase().getForecastDao().delete(item);
                getDatabase().getWeatherDao().deleteWeatherByCityId(item.getId());
                Log.d(TAG, "Forecast deleted");
            }
        }).start();
    }
}

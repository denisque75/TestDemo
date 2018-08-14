package com.denysque.testdemo.core.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.denysque.testdemo.core.models.Forecast;
import com.denysque.testdemo.core.models.Weather;

import static com.denysque.testdemo.core.db.AppDatabase.DB_VERSION;

@Database(entities = {
        Forecast.class,
        Weather.class
},
        version = DB_VERSION,
        exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static final int DB_VERSION = 1;

    public abstract ForecastDao getForecastDao();

    public abstract WeatherDao getWeatherDao();

    //clean method
}

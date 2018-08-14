package com.denysque.testdemo.core.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.denysque.testdemo.core.models.Weather;

import java.util.List;

@Dao
public interface WeatherDao {

    @Query("SELECT * FROM Weather WHERE weatherId = :weatherId")
    List<Weather> getWeather(int weatherId);
}

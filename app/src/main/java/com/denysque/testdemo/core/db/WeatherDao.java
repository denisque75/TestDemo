package com.denysque.testdemo.core.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.denysque.testdemo.core.models.Weather;

import java.util.List;

@Dao
public interface WeatherDao extends BaseDao<Weather> {

    @Query("SELECT * FROM Weather WHERE weatherId = :weatherId AND time < :currentTime")
    List<Weather> getWeather(long weatherId, long currentTime);

    @Query("SELECT * FROM Weather WHERE (SELECT MAX(time) FROM Weather WHERE weatherId = :weatherId) = time AND weatherId = :weatherId")
    List<Weather> getLastWeather(long weatherId);
}

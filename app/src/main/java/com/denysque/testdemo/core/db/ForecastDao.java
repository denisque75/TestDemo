package com.denysque.testdemo.core.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.denysque.testdemo.core.models.Forecast;

import java.util.List;

@Dao
public interface ForecastDao {

    @Query("SELECT * FROM Forecast")
    List<Forecast> getAllForecasts();
}

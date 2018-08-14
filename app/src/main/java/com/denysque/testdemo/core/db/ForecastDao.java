package com.denysque.testdemo.core.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.denysque.testdemo.core.models.Forecast;

import java.util.List;

@Dao
public interface ForecastDao extends BaseDao<Forecast> {

    @Query("SELECT * FROM Forecast")
    List<Forecast> getAllForecasts();

    @Query("SELECT id FROM Forecast")
    List<Long> getAllCitiesId();
}

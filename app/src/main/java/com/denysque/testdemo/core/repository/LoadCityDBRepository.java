package com.denysque.testdemo.core.repository;

import com.denysque.testdemo.core.db.AppDatabase;

public class LoadCityDBRepository extends BaseDBRepository implements CityRepository {

    public LoadCityDBRepository(AppDatabase database) {
        super(database);
    }

    @Override
    public void loadCityForecastFromRepo(long cityId, LoadCityForecastCallback callback) {


    }
}

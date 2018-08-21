package com.denysque.testdemo.core.repository.db;

import com.denysque.testdemo.core.db.AppDatabase;

public abstract class BaseDBRepository {
    private final AppDatabase database;

    public BaseDBRepository(AppDatabase database) {
        this.database = database;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}

package com.denysque.testdemo;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.denysque.testdemo.core.db.AppDatabase;

public class App extends Application {
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();

        setupDatabase();
    }

    private void setupDatabase() {
        database = Room
                .databaseBuilder(getApplicationContext(), AppDatabase.class, BuildConfig.DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public AppDatabase getDatabase() {
        return database;
    }
}

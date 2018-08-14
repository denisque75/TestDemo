package com.denysque.testdemo.core.db;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

public interface BaseDao<T> {
    @Insert(onConflict = REPLACE)
    void insert(T item);

    @Insert(onConflict = REPLACE)
    void insert(List<T> items);

    @Update(onConflict = REPLACE)
    void update(T item);

    @Delete
    void delete(T item);
}

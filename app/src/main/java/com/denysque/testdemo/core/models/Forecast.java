package com.denysque.testdemo.core.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity
public class Forecast {

    @SerializedName("list")
    @Ignore
    List<Weather> weatherList;
    @PrimaryKey(autoGenerate = true)
    private long id;
    @SerializedName("city.name")
    private String city;
    @SerializedName("message")
    private String country;
    private long updatedTime;

    public Forecast() {
    }

    public Forecast(int id, String city, String country, long updatedTime) {
        this.id = id;
        this.city = city;
        this.country = country;
    }

    public Forecast(int id, String city, String country, List<Weather> weatherList, long updatedTime) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.weatherList = weatherList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(long updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", weatherList=" + weatherList +
                '}';
    }
}

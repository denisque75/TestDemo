package com.denysque.testdemo.core.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Weather {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int weatherId;

    @SerializedName("main.humidity")
    private int humidity;
    @SerializedName("main.temp")
    private float temp;
    private float maxTemp;
    private float minTemp;
    private long time;
    private String mainWeatherDesc;
    private String icon;

    public Weather() {
    }

    public Weather(int id, int weatherId, int humidity, float temp, float maxTemp, float minTemp, long time, String mainWeatherDesc, String icon) {
        this.id = id;
        this.weatherId = weatherId;
        this.humidity = humidity;
        this.temp = temp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.time = time;
        this.mainWeatherDesc = mainWeatherDesc;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(float maxTemp) {
        this.maxTemp = maxTemp;
    }

    public float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(float minTemp) {
        this.minTemp = minTemp;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMainWeatherDesc() {
        return mainWeatherDesc;
    }

    public void setMainWeatherDesc(String mainWeatherDesc) {
        this.mainWeatherDesc = mainWeatherDesc;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", weatherId=" + weatherId +
                ", humidity=" + humidity +
                ", temp=" + temp +
                ", maxTemp=" + maxTemp +
                ", minTemp=" + minTemp +
                ", time=" + time +
                ", mainWeatherDesc='" + mainWeatherDesc + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}

package com.denysque.testdemo.core.pojo;

public class CityForecast {
    private float temp;
    private float maxTemp;
    private float minTemp;
    private int humidity;
    private String city;
    private String mainWeatherDesc;
    private String time;

    public CityForecast(float temp, float maxTemp, float minTemp, int humidity, String city, String mainWeatherDesc, String time) {
        this.temp = temp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.humidity = humidity;
        this.city = city;
        this.mainWeatherDesc = mainWeatherDesc;
        this.time = time;
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

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMainWeatherDesc() {
        return mainWeatherDesc;
    }

    public void setMainWeatherDesc(String mainWeatherDesc) {
        this.mainWeatherDesc = mainWeatherDesc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

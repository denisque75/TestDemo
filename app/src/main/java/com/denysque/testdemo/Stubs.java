package com.denysque.testdemo;

import com.denysque.testdemo.core.pojo.CityForecast;
import com.denysque.testdemo.core.pojo.Forecast;

import java.util.ArrayList;
import java.util.List;

public class Stubs {

    private Stubs() {
    }

    public static List<Forecast> getForecastList() {
        List<Forecast> forecasts = new ArrayList<>();

        Forecast forecast = new Forecast("Kharkiv", "Kharkivska oblast", "8 August 18:00", 25, 18, 28);
        forecasts.add(forecast);

        forecast = new Forecast("Kyiv", "Kyivska oblast", "8 August 18:00", 26, 19, 30);
        forecasts.add(forecast);

        forecast = new Forecast("Lviv", "Lvivska oblast", "8 August 18:00", 23, 15, 26);
        forecasts.add(forecast);

        forecast = new Forecast("Odessa", "Odesska oblast", "8 August 18:00", 28, 20, 33);
        forecasts.add(forecast);

        forecast = new Forecast("Dnipro", "Dniprovska oblast", "8 August 18:00", 25, 18, 29);
        forecasts.add(forecast);

        forecast = new Forecast("Kharkiv", "Kharkivska oblast", "8 August 18:00", 25, 18, 28);
        forecasts.add(forecast);

        forecast = new Forecast("Kyiv", "Kyivska oblast", "8 August 18:00", 26, 19, 30);
        forecasts.add(forecast);

        forecast = new Forecast("Lviv", "Lvivska oblast", "8 August 18:00", 23, 15, 26);
        forecasts.add(forecast);

        forecast = new Forecast("Odessa", "Odesska oblast", "8 August 18:00", 28, 20, 33);
        forecasts.add(forecast);

        forecast = new Forecast("Dnipro", "Dniprovska oblast", "8 August 18:00", 25, 18, 29);
        forecasts.add(forecast);
        forecast = new Forecast("Kharkiv", "Kharkivska oblast", "8 August 18:00", 25, 18, 28);
        forecasts.add(forecast);

        forecast = new Forecast("Kyiv", "Kyivska oblast", "8 August 18:00", 26, 19, 30);
        forecasts.add(forecast);

        forecast = new Forecast("Lviv", "Lvivska oblast", "8 August 18:00", 23, 15, 26);
        forecasts.add(forecast);

        forecast = new Forecast("Odessa", "Odesska oblast", "8 August 18:00", 28, 20, 33);
        forecasts.add(forecast);

        forecast = new Forecast("Dnipro", "Dniprovska oblast", "8 August 18:00", 25, 18, 29);
        forecasts.add(forecast);
        forecast = new Forecast("Kharkiv", "Kharkivska oblast", "8 August 18:00", 25, 18, 28);
        forecasts.add(forecast);

        forecast = new Forecast("Kyiv", "Kyivska oblast", "8 August 18:00", 26, 19, 30);
        forecasts.add(forecast);

        forecast = new Forecast("Lviv", "Lvivska oblast", "8 August 18:00", 23, 15, 26);
        forecasts.add(forecast);

        forecast = new Forecast("Odessa", "Odesska oblast", "8 August 18:00", 28, 20, 33);
        forecasts.add(forecast);

        forecast = new Forecast("Dnipro", "Dniprovska oblast", "8 August 18:00", 25, 18, 29);
        forecasts.add(forecast);

        return forecasts;
    }

    public static List<CityForecast> getCityForecasts() {
        List<CityForecast> cityForecasts = new ArrayList<>();

        CityForecast cityForecast = new CityForecast(24.2f, 25.9f, 21f, 12, "Kharkiv", "Sunny", "12:00");
        cityForecasts.add(cityForecast);

        cityForecast = new CityForecast(25.1f, 28.2f, 21.3f, 14, "Kharkiv", "Sunny", "15:00");
        cityForecasts.add(cityForecast);

        cityForecast = new CityForecast(24.2f, 25.9f, 21f, 12, "Kharkiv", "Sunny", "18:00");
        cityForecasts.add(cityForecast);

        cityForecast = new CityForecast(24.2f, 25.9f, 21f, 12, "Kharkiv", "Sunny", "21:00");
        cityForecasts.add(cityForecast);

        cityForecast = new CityForecast(24.2f, 25.9f, 21f, 12, "Kharkiv", "Sunny", "00:00");
        cityForecasts.add(cityForecast);

        cityForecast = new CityForecast(24.2f, 25.9f, 21f, 12, "Kharkiv", "Sunny", "03:00");
        cityForecasts.add(cityForecast);

        cityForecast = new CityForecast(24.2f, 25.9f, 21f, 12, "Kharkiv", "Sunny", "06:00");
        cityForecasts.add(cityForecast);

        cityForecast = new CityForecast(24.2f, 25.9f, 21f, 12, "Kharkiv", "Sunny", "09:00");
        cityForecasts.add(cityForecast);

        return cityForecasts;
    }
}

package com.denysque.testdemo.core.retrofit;

import com.denysque.testdemo.core.models.Forecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {
    String FIND_CITY = "data/2.5/forecast";
    String UNITS = "metric";

    @GET(FIND_CITY)
    Call<Forecast> getForecasts(@Query("q") String city, @Query("units") String units, @Query("APPID") String appId);

    @GET(FIND_CITY)
    Call<Forecast> getForecasts(@Query("id") long cityId, @Query("units") String units, @Query("APPID") String appId);
}

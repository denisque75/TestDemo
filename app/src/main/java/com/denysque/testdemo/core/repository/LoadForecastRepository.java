package com.denysque.testdemo.core.repository;

import android.support.annotation.NonNull;
import android.util.Log;

import com.denysque.testdemo.BuildConfig;
import com.denysque.testdemo.core.models.Forecast;
import com.denysque.testdemo.core.retrofit.WeatherAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadForecastRepository implements ForecastRepository {
    private static final String TAG = "LoadForecastRepository";
    private final WeatherAPI weatherAPI;

    public LoadForecastRepository(WeatherAPI weatherAPI) {
        this.weatherAPI = weatherAPI;
    }

    @Override
    public void loadForecastsFromRepo(final String city, final LoadForecastCallback callback) {
        weatherAPI.getForecasts(city, WeatherAPI.UNITS, BuildConfig.API_KEY).enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(@NonNull Call<Forecast> call, @NonNull Response<Forecast> response) {
                Forecast forecasts = response.body();
                if (forecasts != null) {
                    forecasts.setCity(city);
                }
                Log.d(TAG, "onResponse: forecast[0] = " + forecasts);
                callback.forecastResult(forecasts);
            }

            @Override
            public void onFailure(@NonNull Call<Forecast> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: ", t);
                callback.forecastResult(null);
            }
        });
    }

    @Override
    public void loadCityForecastFromRepo(LoadCityForecastCallback callback) {

    }
}

package com.denysque.testdemo.core.retrofit;

import retrofit2.Retrofit;

public class WeatherApiRetrofit {
    private final Retrofit retrofit;

    public WeatherApiRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public <T> T create(Class<T> t) {
        return retrofit.create(t);
    }
}

package com.denysque.testdemo.utils;

import com.denysque.testdemo.BuildConfig;
import com.denysque.testdemo.core.models.Forecast;
import com.denysque.testdemo.core.retrofit.CustomDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCreator {

    private RetrofitCreator() {
    }

    public static Retrofit createRetrofit() {
        Gson gson = new GsonBuilder().registerTypeAdapter(Forecast.class, new CustomDeserializer()).create();
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}

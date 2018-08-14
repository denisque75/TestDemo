package com.denysque.testdemo.core.retrofit;

import com.denysque.testdemo.core.models.Forecast;
import com.denysque.testdemo.core.models.Weather;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CustomDeserializer implements JsonDeserializer<Forecast> {

    @Override
    public Forecast deserialize(JsonElement forecastJson, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement weatherObject = forecastJson.getAsJsonObject().get("list");
        JsonArray jsonWeatherList = weatherObject.getAsJsonArray();

        Forecast forecast = new Forecast();
        List<Weather> weatherList = new ArrayList<>();

        JsonElement cityElement = forecastJson.getAsJsonObject().get("city");
        forecast.setCity(cityElement.getAsJsonObject().get("name").getAsString());
        forecast.setId(cityElement.getAsJsonObject().get("id").getAsLong());

        long weatherId = forecast.getId();
        for (JsonElement weatherJson : jsonWeatherList) {
            Weather weather = new Weather();
            weather.setId(forecast.getCity() + weatherId++);
            weather.setWeatherId(forecast.getId());
            weather.setTime(weatherJson.getAsJsonObject().get("dt").getAsLong());

            JsonElement mainElement = weatherJson.getAsJsonObject().get("main");

            weather.setTemp(mainElement.getAsJsonObject().get("temp").getAsFloat());
            weather.setMaxTemp(mainElement.getAsJsonObject().get("temp_max").getAsFloat());
            weather.setMinTemp(mainElement.getAsJsonObject().get("temp_min").getAsFloat());
            weather.setHumidity(mainElement.getAsJsonObject().get("humidity").getAsInt());

            JsonArray weatherElementArray = weatherJson.getAsJsonObject().get("weather").getAsJsonArray();
            JsonElement weatherElement = weatherElementArray.get(0);

            weather.setIcon(weatherElement.getAsJsonObject().get("icon").getAsString());
            weather.setMainWeatherDesc(weatherElement.getAsJsonObject().get("main").getAsString());

            weatherList.add(weather);
        }
        forecast.setWeatherList(weatherList);

        forecast.setUpdatedTime(Calendar.getInstance().getTime().getTime());
        return forecast;
    }
}

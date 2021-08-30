package com.prakriti.weatherappretrofit.network;

import com.prakriti.weatherappretrofit.pojo.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCaller {

    String BASE_URL = "https://api.openweathermap.org/data/2.5/"; // "weather?q=" + location + "&units=metric&appid=66f3cfea2d52f0f35c01a1b9b39d2ff5"

    @GET("weather")
    Call<WeatherInfo> getResponse(@Query("q") String q, @Query("units") String units, @Query("appid") String appid);
}

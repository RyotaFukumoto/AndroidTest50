package com.example.ryota.androidtest31;

import android.util.Log;

import com.example.ryota.androidtest31.api.LicensorWeatherWebService;
import com.example.ryota.androidtest31.api.model.Weather;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherAPI {
    private static String API_URL = "http://weather.livedoor.com/forecast/webservice/json/";
    private static Retrofit retrofit = null;
    private WeatherApiCallback weatherApiCallback;
    private LicensorWeatherWebService licensorWeatherWebService;



    WeatherAPI(WeatherApiCallback callback){
        this.weatherApiCallback = callback;
    }

    public void weatherGet(){
       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl(API_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build();
       licensorWeatherWebService = retrofit.create(LicensorWeatherWebService.class);

       Call<Weather> call = licensorWeatherWebService.webservice(130010);

       call.enqueue( new Callback<Weather>() {
           @Override
           public void onResponse(Call<Weather> call, Response<Weather> response) {
               Weather weather = response.body();

                   weatherApiCallback.failed();
               if (weather != null) {
                   weatherApiCallback.success(weather);
               } else {
                   weatherApiCallback.failed();
                   Log.d("test", "weather is null");
               }
           }

           @Override
           public void onFailure(Call<Weather> call, Throwable t) {
               weatherApiCallback.failed();
           }
       });
    }
    public interface WeatherApiCallback {
        void success(Weather weather);
        void failed();
    }
}

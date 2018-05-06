package com.example.ryota.androidtest31.api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.util.Log;

import com.example.ryota.androidtest31.api.model.Weather;


public class WeatherApi {
    private static final String TAG = "WeatherApi";
    private static final String API_URL = "http://weather.livedoor.com/forecast/webservice/json/";

    public interface WeatherApiCallback {
        void success(Weather weather);
        void failed();
    }

    private final WeatherApiCallback callback;

    public WeatherApi(WeatherApiCallback callback) {
        this.callback = callback;
    }

    public void getWeather(){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LicensorWeatherWebService service = retrofit.create(LicensorWeatherWebService.class);
        Call<Weather> call = service.webservice("130010");


        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Weather weather = response.body();
                if (weather != null) {
                    WeatherApi.this.callback.success(weather);
                } else {
                    WeatherApi.this.callback.failed();
                    Log.d(TAG, "weather is null");
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                WeatherApi.this.callback.failed();
                Log.d(TAG, "error");
            }
        });
    }
}
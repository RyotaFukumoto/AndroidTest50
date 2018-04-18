package com.example.ryota.androidtest31;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherAPI {
    public static final String API_URL = "http://weather.livedoor.com/forecast/webservice/json/";
    private static Retrofit retrofit=null;

    public  static Retrofit getClient(){
        if(retrofit==null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}

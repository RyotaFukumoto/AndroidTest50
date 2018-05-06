package com.example.ryota.androidtest31.api;

import com.example.ryota.androidtest31.api.model.Weather;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface LicensorWeatherWebService {
    @GET("v1")
    Call<Weather> webservice(@Query("city") String city);
}

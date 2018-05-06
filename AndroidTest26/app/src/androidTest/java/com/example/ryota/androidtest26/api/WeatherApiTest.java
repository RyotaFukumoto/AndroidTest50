package com.example.ryota.androidtest26.api;

import com.example.ryota.androidtest26.

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WeatherApiTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getWeather() {
        WeatherApi weatherApi =  new WeatherApi(new WeatherApi.WeatherApiCallback() {
            @Override
            public void success(Weather weather) {
                assertEquals(weather.getLocation().getCity(),"東京");
                assertEquals(weather.getForecasts().get(0).getDateLabel(),"今日");
            }

            @Override
            public void failed() {

            }
        });
        weatherApi.getWeather();
    }
}
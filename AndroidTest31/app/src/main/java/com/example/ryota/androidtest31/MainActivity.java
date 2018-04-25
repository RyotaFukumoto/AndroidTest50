package com.example.ryota.androidtest31;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ryota.androidtest31.api.LicensorWeatherWebService;
import com.example.ryota.androidtest31.api.model.Forecast;
import com.example.ryota.androidtest31.api.model.Weather;

import java.util.List;

public class MainActivity extends AppCompatActivity implements WeatherAPI.WeatherApiCallback{


    private WeatherAPI wApi;
    private LicensorWeatherWebService service;
    private WeatherRecyclerViewAdapter adapter;
    private TextView telop;
    private RowViewHolder holder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        telop = findViewById(R.id.textView2);
        adapter = new WeatherRecyclerViewAdapter();
        holder = new RowViewHolder();

        RecyclerView recyclerView = findViewById(R.id.recyclreView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        wApi = new WeatherAPI(this);
        getWeather();

    }



    void getWeather(){
        wApi.weatherGet();
    }


    @Override
    public void success(Weather weather) {
        if (weather != null) {
            telop.setText(weather.getDescription().getText());
            List<Forecast> list = weather.getForecasts();

            adapter.listSetter(list);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void failed() {

    }
}
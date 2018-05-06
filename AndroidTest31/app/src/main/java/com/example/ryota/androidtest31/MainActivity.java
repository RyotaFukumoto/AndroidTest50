package com.example.ryota.androidtest31;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.ryota.androidtest31.api.WeatherApi;
import com.example.ryota.androidtest31.api.model.Forecast;
import com.example.ryota.androidtest31.api.model.Weather;

import java.util.List;

public class MainActivity extends AppCompatActivity implements WeatherApi.WeatherApiCallback{

    private WeatherApi weatherApi;
    private int position;
    private WeatherRecyclerViewAdapter adapter;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclreView);
        this.description = (TextView) findViewById(R.id.textView2);
        this.adapter = new WeatherRecyclerViewAdapter();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(this.adapter);

        this.weatherApi = new WeatherApi(this);
        getForecast();
    }
    @Override
    public void success(Weather weather) {
        if (weather != null) {
            this.description.setText(weather.getDescription().getText());
            List<Forecast> forecasts = weather.getForecasts();

            this.adapter.setForecasts(forecasts);
            this.adapter.notifyDataSetChanged();
        }
    }
    @Override
    public void failed() {

    }
    private void getForecast(){
        this.weatherApi.getWeather();
    }

}
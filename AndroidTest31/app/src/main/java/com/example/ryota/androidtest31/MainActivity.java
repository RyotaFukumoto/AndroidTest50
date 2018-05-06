package com.example.ryota.androidtest31;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.ryota.androidtest31.api.WeatherApi;
import com.example.ryota.androidtest31.api.model.Description;
import com.example.ryota.androidtest31.api.model.Forecast;
import com.example.ryota.androidtest31.api.model.Weather;
import com.example.ryota.androidtest31.database.ForecastDatabase;
import com.example.ryota.androidtest31.database.Insert;
import com.example.ryota.androidtest31.database.ResponseData;
import com.example.ryota.androidtest31.database.Select;

import java.util.List;

public class MainActivity extends AppCompatActivity implements WeatherApi.WeatherApiCallback{

    private WeatherApi weatherApi;
    private int position;
    private WeatherRecyclerViewAdapter adapter;
    private TextView description;
    private ForecastDatabase forecastDB;

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
        this.forecastDB = Room.databaseBuilder(getApplicationContext(),ForecastDatabase.class, "forecastDatabase").build();
        getForecast();
    }


    private void getForecast(){
        this.weatherApi.getWeather();
    }


    @Override
    public void success(Weather weather) {
        if (weather != null) {
            List<Forecast> forecasts = weather.getForecasts();

            Description description = new Description();
            description.setText(weather.getDescription().getText());

            Insert insert = new Insert(this, description, forecasts);


            insert.execute();
        }
    }

    @Override
    public void failed() {
        Log.d("System.err", "error");
    }

    public ForecastDatabase getForecastDB() {
        return this.forecastDB;
    }

    public void changedDB(){
        Log.i("System.out","changedDB");
        Select select = new Select(this);
        select.execute();
    }

    public void selected(ResponseData res){
        Log.i("System.out","selected");

        this.description.setText(res.getDescription());
        this.adapter.setForecasts(res.getForecastDataList());
        this.adapter.notifyDataSetChanged();
    }
}
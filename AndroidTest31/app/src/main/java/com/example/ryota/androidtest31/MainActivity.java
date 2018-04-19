package com.example.ryota.androidtest31;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.example.ryota.androidtest31.api.LicensorWeatherWebService;
import com.example.ryota.androidtest31.api.model.Weather;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements WeatherViewListener{
    public static final String TAG = "MainActivity";
    public static final String API_URL = "http://weather.livedoor.com/forecast/webservice/json/";
    private Handler handler = new Handler();
    private int i = 0;
    private Button button;
    private LicensorWeatherWebService service;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private WeatherRecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.casarealRecyclerView);
        service = WeatherAPI.getClient().create(LicensorWeatherWebService.class);
        adapter = new WeatherRecycleViewAdapter(getForecast());
        linearLayoutManager = new LinearLayoutManager(this);

    }




    private List<WeathRow> getForecast(){

            Call<Weather> call = service.webservice(130010);
            final List<WeathRow> weathRowList = new  ArrayList<>();
            call.enqueue(new Callback<Weather>() {
                @Override
                public void onResponse(Call<Weather> call, Response<Weather> response) {
                    for (int i = 0; i < response.body().forecasts.size(); i++) {
                        WeathRow weathRow = new WeathRow();
                            weathRow.setImage(response.body().forecasts.get(i).image.url);
                        weathRow.setWeather(response.body().forecasts.get(i).telop);

                        weathRow.setDay(response.body().forecasts.get(i).date);
                        Log.d("list",response.body().forecasts.get(i).date);
                        if(response.body().forecasts.get(i).temperature.getMax() != null){
                            weathRow.setMax(response.body().forecasts.get(i).temperature.max.celsius);
                        }
                        if(response.body().forecasts.get(i).temperature.getMin() != null){
                            weathRow.setMin(response.body().forecasts.get(i).temperature.min.celsius);
                        }

                        weathRowList.add(weathRow);

                    }
                    ViewReload();
                }

                @Override
                public void onFailure(Call<Weather> call, Throwable t) {
                    Log.d("onFailure",t.getMessage());
                }
            });
            Log.i("list", String.valueOf(weathRowList));

        return weathRowList;
    }


    @Override
    public void ViewReload() {


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
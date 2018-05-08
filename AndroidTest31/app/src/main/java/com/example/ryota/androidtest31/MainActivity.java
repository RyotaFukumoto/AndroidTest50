package com.example.ryota.androidtest31;

import android.app.Activity;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.example.ryota.androidtest31.api.LicensorWeatherWebService;
import com.example.ryota.androidtest31.api.model.Weather;
import com.example.ryota.androidtest31.db.DatabaseListener;
import com.example.ryota.androidtest31.db.WeathRow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements DatabaseListener,WeatherViewListener{
    public static final String TAG = "MainActivity";
    public static final String API_URL = "http://weather.livedoor.com/forecast/webservice/json/";
    private Handler handler = new Handler();
    private int i = 0;
    private Button button;
    private LicensorWeatherWebService service;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private WeatherRecycleViewAdapter adapter;
    private DBInsert dbInsert;
    private List<WeathRow> list = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.casarealRecyclerView);
        service = WeatherAPI.getClient().create(LicensorWeatherWebService.class);

        linearLayoutManager = new LinearLayoutManager(this);

        list = new ArrayList<>();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new WeatherRecycleViewAdapter(list);
        recyclerView.setAdapter(adapter);
        getForecast();

    }



<<<<<<< HEAD
                    call.enqueue(new Callback<Weather>() {
                        @Override
                        public void onResponse(Call<Weather> call, Response<Weather> response) {
                            Log.d("onResponse",response.body().getForecasts().get(position).getTelop());
                            Log.d("onResponse",response.body().getForecasts().get(position).getDate());
                        }
=======
>>>>>>> AndroidTest35

    private void getForecast(){

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
                    databeseIinsert(weathRowList);
                }

                @Override
                public void onFailure(Call<Weather> call, Throwable t) {
                    Log.d("onFailure",t.getMessage());
                }
            });
            Log.i("list", String.valueOf(weathRowList));


    }


    @Override
    public  void databeseIinsert(final List<WeathRow> list) {
        dbInsert = new DBInsert();
        Log.d("db","maindata" );
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("db","ddd");
                List<WeathRow> rows = dbInsert.setDatabese(list, getApplicationContext());
//                    ViewReload();
                //Log.d("dba", String.valueOf(rows.get(0).getDay()));
                ViewReload(rows);

            }
        });
        thread.start();

    }

    @Override
    public void ViewReload(List<WeathRow> list) {
        Log.d("dba", String.valueOf(list.get(0).getDay()));
        this.list.addAll(list);
        Log.d("db","aaaa");
        adapter.notifyDataSetChanged();
//        updateToRecyclerView(list);
    }

    public void updateToRecyclerView(List<WeathRow> weathRow) {
        if (list != null) {
            Log.d("db",list.get(0).getDay());
            int index = list.indexOf(weathRow);
            if (-1 != index) {
//                adapter.notifyItemInserted(weathRow);
                recyclerView.invalidate();
            }
        }
    }

//    @Override
//    public void ViewReload() {
//        adapter = new WeatherRecycleViewAdapter();
//        linearLayoutManager = new LinearLayoutManager(this);
//
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(adapter);
//    }
//

}
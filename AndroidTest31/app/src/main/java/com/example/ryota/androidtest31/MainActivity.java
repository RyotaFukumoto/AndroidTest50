package com.example.ryota.androidtest31;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ryota.androidtest31.api.LicensorWeatherWebService;
import com.example.ryota.androidtest31.api.model.Forecast;
import com.example.ryota.androidtest31.api.model.Weather;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,WeatherDialogFragment.WeatherDialogFragmentListener{
    public static final String TAG = "MainActivity";
    public static final String API_URL = "http://weather.livedoor.com/forecast/webservice/json/";
    private Handler handler = new Handler();
    private int i = 0;
    private Button button;
    LicensorWeatherWebService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = WeatherAPI.getClient().create(LicensorWeatherWebService.class);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        WeatherDialogFragment weatherDialogFragment = new WeatherDialogFragment();
        weatherDialogFragment.setListener(this);
        weatherDialogFragment.show(getFragmentManager(),"fragment");
    }

    void getForecast(final int position){

                    Call<Weather> call = service.webservice(130010);

                    call.enqueue(new Callback<Weather>() {
                        @Override
                        public void onResponse(Call<Weather> call, Response<Weather> response) {
                            Log.d("onResponse",response.body().getForecasts().get(position).getTelop());
                            Log.d("onResponse",response.body().getForecasts().get(position).getDate());
                        }

                        @Override
                        public void onFailure(Call<Weather> call, Throwable t) {
                            Log.d("onFailure",t.getMessage());
                        }
                    });
                   
    }

    @Override
    public void onClicked(int position) {
        getForecast(position);
    }
}
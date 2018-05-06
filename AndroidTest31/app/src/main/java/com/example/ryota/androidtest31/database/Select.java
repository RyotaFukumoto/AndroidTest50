package com.example.ryota.androidtest31.database;

import android.os.AsyncTask;

import com.example.ryota.androidtest31.MainActivity;
import com.example.ryota.androidtest31.api.model.Forecast;

import java.lang.ref.WeakReference;
import java.util.List;

public class Select extends AsyncTask<Void,Void,ResponseData> {

    private ForecastDatabase forecastDB;
    private final WeakReference<MainActivity> activityReference;

    public Select(MainActivity context) {
        super();
        this.activityReference = new WeakReference<>(context);
    }


    @Override
    protected ResponseData doInBackground(Void... voids) {
        ResponseData res = new ResponseData();
        String description = this.activityReference.get()
                .getForecastDB()
                .descriptionDao()
                .getNewest()
                .getText();
        res.setDescription(description);
        List<Forecast> forecastEntities = this.activityReference.get()
                .getForecastDB()
                .forecastDao()
                .getNewest();
        res.setForecastList(forecastEntities);
        return res;
    }

    @Override
    protected void onPostExecute(ResponseData responseData) {
        if (responseData != null){
            this.activityReference.get().selected(responseData);
        }
    }
}

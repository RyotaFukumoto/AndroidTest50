package com.example.ryota.androidtest31.database;

import android.os.AsyncTask;

import com.example.ryota.androidtest31.MainActivity;
import com.example.ryota.androidtest31.api.model.Description;
import com.example.ryota.androidtest31.api.model.Forecast;

import java.lang.ref.WeakReference;
import java.util.List;

public class Insert extends AsyncTask<Void,Void,Boolean> {

    private final WeakReference<MainActivity> activityReference;
    private final Description description;
    private final List<Forecast> forecastEntities;

    public Insert(MainActivity context, Description description, List<Forecast> forecastEntities) {
        super();
        this.activityReference = new WeakReference<>(context);
        this.description = description;
        this.forecastEntities = forecastEntities;
    }

    @Override
    protected Boolean doInBackground(Void... objs) {
        // retrieve auto incremented note id

        this.activityReference.get().getForecastDB().forecastDao().deleteALL();
        this.activityReference.get().getForecastDB().descriptionDao().deleteALL();


        this.activityReference.get().getForecastDB().descriptionDao().insertEntity(this.description);
        for(Forecast forecastEntity : this.forecastEntities){
            this.activityReference.get().getForecastDB().forecastDao().insertEntity(forecastEntity);
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean bool) {
        if (bool){
            this.activityReference.get().changedDB();
        }
    }
}

package com.example.ryota.androidtest31;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.ryota.androidtest31.api.model.Forecast;

import java.util.ArrayList;
import java.util.List;
class WeatherRecyclerViewAdapter extends RecyclerView.Adapter<WeatherViewHolder> {
    private Context context;
    private List<Forecast> forecasts = new ArrayList<>();

    void setForecasts(List<Forecast> forecasts){
        this.forecasts = forecasts;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,false);
        this.context = parent.getContext();
        return new WeatherViewHolder(inflate);
    }
    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
<<<<<<< HEAD:AndroidTest31/app/src/main/java/com/example/ryota/androidtest31/WeatherRecyclerViewAdapter.java
        holder.getDateTextView().setText(this.forecasts.get(position).getDateLabel());
=======
        holder.getDateTextView().setText(this.forecasts.get(position).getDate());
>>>>>>> AndroidTest32:AndroidTest31/app/src/main/java/com/example/ryota/androidtest31/WeatherRecyclerViewAdapter.java
        holder.getForecastTextView().setText(this.forecasts.get(position).getTelop());
        Glide.with(this.context).load(this.forecasts.get(position).getImage().getUrl()).into(holder.getIconImageView());
    }
    @Override
    public int getItemCount() {
        return this.forecasts.size();
    }
}
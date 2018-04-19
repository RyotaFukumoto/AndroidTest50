package com.example.ryota.androidtest31;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

public class WeatherRecycleViewAdapter extends RecyclerView.Adapter<WeatherViewHolder> {
    private final List<WeathRow> list;
    private static Context context;
    public WeatherRecycleViewAdapter(List<WeathRow> list) {
        super();
        this.list = list;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.weatheer_row,parent,false);
        return new WeatherViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {

        Glide.with(holder.imageView).load(this.list.get(position).getImage()).into(holder.imageView);
        holder.dayView.setText(this.list.get(position).getDay());
        holder.weatherView.setText(this.list.get(position).getWeather());
        holder.maxView.setText("最高気温"+this.list.get(position).getMax());
        holder.minView.setText("最低気温"+this.list.get(position).getMin());
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}

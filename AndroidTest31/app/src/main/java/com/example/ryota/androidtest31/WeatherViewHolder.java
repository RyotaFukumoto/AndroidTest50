package com.example.ryota.androidtest31;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherViewHolder extends RecyclerView.ViewHolder{
    public final ImageView imageView;
    public final TextView dayView;
    public final TextView weatherView;
    public final TextView maxView;
    public final TextView minView;
    public WeatherViewHolder(View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.imageView);
        this.dayView = itemView.findViewById(R.id.dayView);
        this.weatherView = itemView.findViewById(R.id.weatherView);
        this.maxView = itemView.findViewById(R.id.maxView);
        this.minView = itemView.findViewById(R.id.minView);
    }
}

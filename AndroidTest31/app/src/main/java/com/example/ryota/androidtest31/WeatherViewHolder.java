package com.example.ryota.androidtest31;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherViewHolder extends RecyclerView.ViewHolder {
    private ImageView iconImageView;
    private TextView dateTextView;
    private TextView forecastTextView;

    public WeatherViewHolder(View itemView) {
        super(itemView);

        this.iconImageView = (ImageView) itemView.findViewById(R.id.imageView);
        this.dateTextView = (TextView) itemView.findViewById(R.id.textView3);
        this.forecastTextView = (TextView) itemView.findViewById(R.id.textView4);
    }

    public ImageView getIconImageView() {
        return this.iconImageView;
    }

    public TextView getDateTextView() {
        return this.dateTextView;
    }

    public TextView getForecastTextView() {
        return this.forecastTextView;
    }

    public void setIconImageView(ImageView iconImageView) {
        this.iconImageView = iconImageView;
    }

    public void setDateTextView(TextView dateTextView) {
        this.dateTextView = dateTextView;
    }

    public void setForecastTextView(TextView forecastTextView) {
        this.forecastTextView = forecastTextView;
    }
}
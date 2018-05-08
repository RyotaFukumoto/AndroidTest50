package com.example.ryota.androidtest31;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

<<<<<<< HEAD:AndroidTest31/app/src/main/java/com/example/ryota/androidtest31/WeatherViewHolder.java
<<<<<<< HEAD:AndroidTest31/app/src/main/java/com/example/ryota/androidtest31/WeatherViewHolder.java
<<<<<<< HEAD
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
=======
=======
>>>>>>> AndroidTest32:AndroidTest31/app/src/main/java/com/example/ryota/androidtest31/WeatherViewHolder.java
=======
>>>>>>> AndroidTest34:AndroidTest31/app/src/main/java/com/example/ryota/androidtest31/WeatherViewHolder.java
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
>>>>>>> AndroidTest33
    }
}

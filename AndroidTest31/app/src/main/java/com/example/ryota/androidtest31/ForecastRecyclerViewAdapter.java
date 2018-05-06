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
class ForecastRecyclerViewAdapter extends RecyclerView.Adapter<ForecastViewHolder> {
    private Context context;
    private List<Forecast> forecasts = new ArrayList<>();

    void setForecasts(List<Forecast> forecasts){
        this.forecasts = forecasts;
    }

    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,false);
        this.context = parent.getContext();
        return new ForecastViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
        holder.getDateTextView().setText(this.forecasts.get(position).getDate());
        holder.getForecastTextView().setText(this.forecasts.get(position).getTelop());
        Glide.with(this.context).load(this.forecasts.get(position).getImage().getUrl()).into(holder.getIconImageView());

    }

    @Override
    public int getItemCount() {
        return this.forecasts.size();
    }
}
package com.example.ryota.androidtest31;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.ryota.androidtest31.R;
import com.example.ryota.androidtest31.RowViewHolder;
import com.example.ryota.androidtest31.api.model.Forecast;

import java.util.ArrayList;
import java.util.List;

public class WeatherRecyclerViewAdapter extends RecyclerView.Adapter<RowViewHolder> {
    private List<Forecast> list = new ArrayList<>();
    private Context context;

    void listSetter(List<Forecast> list){
        this.list = list;
    }

    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        this.context = parent.getContext();
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getImage().getUrl()).into(holder.getImgV());
        holder.getDateTexV().setText(list.get(position).dateLabel);
        holder.getWeathTexV().setText(list.get(position).telop);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}

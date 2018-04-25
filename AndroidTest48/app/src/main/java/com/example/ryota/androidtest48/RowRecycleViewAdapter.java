package com.example.ryota.androidtest48;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RowRecycleViewAdapter extends RecyclerView.Adapter<RowViewHolder> {
    private List<DataRow> list = new ArrayList<>();

    RowRecycleViewAdapter(){ }

    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new RowViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int position) {
        holder.textView.setText(this.list.get(position).getWeek());
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public void setList(List<DataRow> list) {
        this.list = list;
    }
}

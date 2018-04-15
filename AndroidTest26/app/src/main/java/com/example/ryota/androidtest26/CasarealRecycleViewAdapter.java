package com.example.ryota.androidtest26;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CasarealRecycleViewAdapter extends RecyclerView.Adapter<CasarealViewHolder> {
    private  List<RowData> list;

    public void setList(List<RowData> list){
        this.list = list;
    }

    @NonNull
    @Override
    public CasarealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new CasarealViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CasarealViewHolder holder, int position) {
    holder.title.setText(this.list.get(position).getTitle());
    holder.limit.setText(this.list.get(position).getLimit());
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}

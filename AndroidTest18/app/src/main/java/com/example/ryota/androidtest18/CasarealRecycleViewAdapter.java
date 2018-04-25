package com.example.ryota.androidtest18;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CasarealRecycleViewAdapter extends RecyclerView.Adapter<CasarealViewHolder> {
    private final List<RowData> list;

    public CasarealRecycleViewAdapter(List<RowData> list) {
        super();
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
        holder.textView.setText((CharSequence) this.list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}

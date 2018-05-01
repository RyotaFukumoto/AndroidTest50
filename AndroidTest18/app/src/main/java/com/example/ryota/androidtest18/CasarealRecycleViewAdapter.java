package com.example.ryota.androidtest18;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

class CasarealRecycleViewAdapter extends RecyclerView.Adapter<CasarealViewHolder> {
<<<<<<< HEAD:AndroidTest18/app/src/main/java/com/example/ryota/androidtest18/CasarealRecycleViewAdapter.java
    private final List<RowData> list;
=======
    private  List<RowData> list;
>>>>>>> AndroidTest27:AndroidTest26/app/src/main/java/com/example/ryota/androidtest26/CasarealRecycleViewAdapter.java

    CasarealRecycleViewAdapter(List<RowData> list) {
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
<<<<<<< HEAD:AndroidTest18/app/src/main/java/com/example/ryota/androidtest18/CasarealRecycleViewAdapter.java
        holder.textView.setText(this.list.get(position).getTitle());
        holder.imageView.setImageDrawable(this.list.get(position).getImage());
=======
    holder.getTitle().setText(this.list.get(position).getTitle());
    holder.getLimit().setText(this.list.get(position).getLimit());
>>>>>>> AndroidTest27:AndroidTest26/app/src/main/java/com/example/ryota/androidtest26/CasarealRecycleViewAdapter.java
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}

package com.example.ryota.androidtest18;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CasarealViewHolder extends RecyclerView.ViewHolder {
    public final TextView textView;
    public final ImageView imageView;
    public CasarealViewHolder(View itemView) {
        super(itemView);
        this.textView = itemView.findViewById(R.id.text);
        this.imageView = itemView.findViewById(R.id.imageView);
    }
}

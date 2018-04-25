package com.example.ryota.androidtest31;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RowViewHolder extends RecyclerView.ViewHolder{
    private ImageView imgV;
    private TextView dateTexV;
    private TextView weathTexV;

    public RowViewHolder(View itemView) {
        super(itemView);
        this.imgV = itemView.findViewById(R.id.imageView);
        this.dateTexV = itemView.findViewById(R.id.textView3);
        this.weathTexV = itemView.findViewById(R.id.textView4);
    }

    public ImageView getImgV() {
        return this.imgV;
    }

    public void setImgV(ImageView imgV) {
        this.imgV = imgV;
    }

    public TextView getDateTexV() {
        return this.dateTexV;
    }

    public void setDateTexV(TextView dateTexV) {
        this.dateTexV = dateTexV;
    }

    public TextView getWeathTexV() {
        return this.weathTexV;
    }

    public void setWeathTexV(TextView weathTexV) {
        this.weathTexV = weathTexV;
    }


}

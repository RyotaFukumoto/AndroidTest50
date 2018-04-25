package com.example.ryota.androidtest48;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RowViewHolder extends RecyclerView.ViewHolder{
    public TextView textView;

    public RowViewHolder(View itemView) {
        super(itemView);
        this.textView = itemView.findViewById(R.id.list_item_text);
    }
}

package com.example.ryota.androidtest26;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

<<<<<<< HEAD
class CasarealViewHolder extends RecyclerView.ViewHolder {
    private final TextView title;
    private final TextView limit;
    CasarealViewHolder(View itemView) {
=======
public class CasarealViewHolder extends RecyclerView.ViewHolder {
    private final TextView title;
    private final TextView limit;
    public CasarealViewHolder(View itemView) {
>>>>>>> AndroidTest27
        super(itemView);

        this.title = itemView.findViewById(R.id.textView3);
        this.limit = itemView.findViewById(R.id.textView4);
    }

    public TextView getLimit() {
        return this.limit;
    }

    public TextView getTitle() {
        return this.title;
    }
}
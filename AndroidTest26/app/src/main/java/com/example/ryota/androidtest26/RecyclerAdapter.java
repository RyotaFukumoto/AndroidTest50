package com.example.ryota.androidtest26;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder> {
    private final Context context;
    private List<RowData> list;
    private View.OnClickListener listener;

    private final RowOnClickedListener rowOnClickedListener;



    RecyclerAdapter(Context context, RowOnClickedListener listener) {
        this.context = context;

        this.rowOnClickedListener = listener;
    }

    public void setList(List<RowData> list){
        this.list = list;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        final RowData item = this.list.get(position);
        holder.getTitle().setText(item.getTitle());
        holder.getLimit().setText(item.getLimit());
        holder.getLinearLayout().setId(holder.getAdapterPosition());
        holder.getLinearLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerAdapter.this.rowOnClickedListener.rowClicked(item);
            }
        });
    }


    @Override
    public int getItemCount() {
        return this.list.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView limit;
        private final LinearLayout linearLayout;

        CustomViewHolder(View itemView) {
            super(itemView);
            this.title =  itemView.findViewById(R.id.textView3);
            this.limit = itemView.findViewById(R.id.textView4);
            this.linearLayout = itemView.findViewById(R.id.linear_layout);
        }

        TextView getTitle() {
            return this.title;
        }

        TextView getLimit() {
            return this.limit;
        }

        LinearLayout getLinearLayout() {
            return this.linearLayout;
        }
    }
}
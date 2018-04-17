package com.example.ryota.androidtest26;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder> {
    private Context context;
    private List<RowData> list;
    private View.OnClickListener listener;

    private RowOnClickedListener rowOnClickedListener;



    public RecyclerAdapter(Context context, List<RowData> list, RowOnClickedListener listener) {
        this.context = context;
        this.list = list;
        this.rowOnClickedListener = listener;
    }

    public void setList(List<RowData> list){
        this.list = list;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final RowData item = list.get(position);
        holder.title.setText(item.getTitle());
        holder.limit.setText(item.getLimit());
        holder.linearLayout.setId(holder.getAdapterPosition());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rowOnClickedListener.rowClicked(item);
            }
        });

        holder.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                rowOnClickedListener.rowLongClicked(item);
                return false;
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {
        final TextView title;
        final TextView limit;
        final LinearLayout linearLayout;

        CustomViewHolder(View itemView) {
            super(itemView);
            title =  itemView.findViewById(R.id.textView3);
            limit = itemView.findViewById(R.id.textView4);
            linearLayout = itemView.findViewById(R.id.linear_layout);
        }
    }
}
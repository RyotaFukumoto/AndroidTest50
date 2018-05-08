package com.example.ryota.androidtest43;
import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

class MusicListRecycleViewAdapter extends RecyclerView.Adapter<MusicListViewHolder> {
    private List<RowData> musicList;
    private int playing = -1;

    interface MusicListListener{
        void play(int filePath);
        void stop();
    }

    private MusicListListener listener;

    void setListener(MusicListListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public MusicListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,false);
        return new MusicListViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final MusicListViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.getMusicNameTextView().setText(this.musicList.get(position).getMusicName());
        if (position == this.playing){
            holder.play();
            holder.setPlaying(true);
        }else{
            holder.stop();
            holder.setPlaying(false);
        }
        holder.getPlayImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.isPlaying()) {
                    MusicListRecycleViewAdapter.this.listener.stop();
                    MusicListRecycleViewAdapter.this.playing = -1;
                } else {
                    MusicListRecycleViewAdapter.this.listener.play(MusicListRecycleViewAdapter.this.musicList.get(position).getId());
                    MusicListRecycleViewAdapter.this.playing = position;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.musicList.size();
    }
    public void setMusicList(List<RowData> musicList) {
        this.musicList = musicList;
    }

    public void complete(){
        playing = -1;
        listener.stop();
    }

}
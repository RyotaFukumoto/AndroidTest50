package com.example.ryota.androidtest43;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicListViewHolder extends RecyclerView.ViewHolder {
    private final ImageView playImageView;
    private final TextView musicNameTextView;
    private boolean playing;

    public MusicListViewHolder(View itemView) {
        super(itemView);
        this.playImageView = (ImageView)itemView.findViewById(R.id.playImageView);
        this.musicNameTextView = (TextView)itemView.findViewById(R.id.musicNameTextView);
        this.playing = false;
    }

    public ImageView getPlayImageView() {
        return this.playImageView;
    }


    public TextView getMusicNameTextView() {
        return this.musicNameTextView;
    }


    public boolean isPlaying() {
        return this.playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void play(){
        this.playImageView.setImageResource(R.drawable.stop);
    }

    public void stop(){
        this.playImageView.setImageResource(R.drawable.play);
    }
}
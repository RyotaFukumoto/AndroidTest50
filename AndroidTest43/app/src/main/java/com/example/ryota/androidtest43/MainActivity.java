package com.example.ryota.androidtest43;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MusicListRecycleViewAdapter.MusicListListener {
    private MediaPlayer mediaPlayer;
    private MusicListRecycleViewAdapter adapter;
    private List<RowData> musicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        this.adapter = new MusicListRecycleViewAdapter();
        this.adapter.setListener(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(llm);
        rv.setAdapter(this.adapter);

        this.musicList = new ArrayList<>();
        this.musicList.add(new RowData("acoustic",R.raw.acoustic));
        this.musicList.add(new RowData("healing",R.raw.healing));
        this.musicList.add(new RowData("neorock",R.raw.neorock));
        this.musicList.add(new RowData("orchestra",R.raw.orchestra));
        this.musicList.add(new RowData("piano",R.raw.piano));
        this.adapter.setMusicList(this.musicList);
        this.adapter.notifyDataSetChanged();

        this.mediaPlayer = new MediaPlayer();
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    @Override
    public void play(int filePath) {
        Log.i("System.out", String.valueOf(filePath));
        this.mediaPlayer.stop();
        this.mediaPlayer.reset();
        this.mediaPlayer = MediaPlayer.create(this, filePath);
        this.mediaPlayer.start();

        reload();
    }

    @Override
    public void stop() {
        this.mediaPlayer.stop();
        this.mediaPlayer.reset();

        reload();
    }

    private void reload(){
        this.adapter.notifyItemRangeChanged(0, this.musicList.size());
    }

}
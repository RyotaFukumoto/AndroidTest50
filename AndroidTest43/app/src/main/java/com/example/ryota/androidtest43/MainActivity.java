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
        adapter = new MusicListRecycleViewAdapter();
        adapter.setListener(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);

        musicList = new ArrayList<>();
        musicList.add(new RowData("acoustic",R.raw.acoustic));
        musicList.add(new RowData("healing",R.raw.healing));
        musicList.add(new RowData("neorock",R.raw.neorock));
        musicList.add(new RowData("orchestra",R.raw.orchestra));
        musicList.add(new RowData("piano",R.raw.piano));
        adapter.setMusicList(musicList);
        adapter.notifyDataSetChanged();

        mediaPlayer = new MediaPlayer();
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    @Override
    public void play(int filePath) {
        Log.i("System.out", String.valueOf(filePath));
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(this, filePath);
        mediaPlayer.start();

        reload();
    }

    @Override
    public void stop() {
        mediaPlayer.stop();
        mediaPlayer.reset();

        reload();
    }

    private void reload(){
        adapter.notifyItemRangeChanged(0, musicList.size());
    }

}
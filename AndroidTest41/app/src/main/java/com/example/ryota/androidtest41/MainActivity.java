package com.example.ryota.androidtest41;


import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    private SeekBar alphaSeekBar;
    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.alphaSeekBar = (SeekBar) findViewById(R.id.alphaSeekBar);
        this.redSeekBar = (SeekBar) findViewById(R.id.redSeekBar);
        this.greenSeekBar = (SeekBar) findViewById(R.id.greenSeekBar);
        this.blueSeekBar = (SeekBar) findViewById(R.id.blueSeekBar);

        this.imageView = (ImageView) findViewById(R.id.imageView);

        this.alphaSeekBar.setOnSeekBarChangeListener(this);
        this.redSeekBar.setOnSeekBarChangeListener(this);
        this.greenSeekBar.setOnSeekBarChangeListener(this);
        this.blueSeekBar.setOnSeekBarChangeListener(this);




    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean bo) {
        int newColor = (this.alphaSeekBar.getProgress() << 24)
                + (this.redSeekBar.getProgress() << 16)
                + (this.greenSeekBar.getProgress() << 8)
                + this.blueSeekBar.getProgress();
        this.imageView.setColorFilter(newColor, PorterDuff.Mode.MULTIPLY);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

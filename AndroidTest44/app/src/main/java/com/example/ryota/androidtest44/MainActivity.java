package com.example.ryota.androidtest44;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,DownloadFileFromURL.DownloadFileListener{
    private ImageView imageView;
    private Button image1Button;
    private Button image2Button;
    private ProgressBar progressBar;

    private boolean downloading = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);

        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.image1Button = (Button) findViewById(R.id.image1Button);
        this.image2Button = (Button) findViewById(R.id.image2Button);
        this.image1Button.setOnClickListener(this);
        this.image2Button.setOnClickListener(this);

        this.downloading = true;
    }

    @Override
    public void onClick(View view) {
        if(this.downloading) {
            this.progressBar.setVisibility(View.VISIBLE);
            if (view.equals(this.image1Button)) {
                new DownloadFileFromURL(this).execute("https://s3-ap-northeast-1.amazonaws.com/petpedia/upload_by_admin/pipi_rabbit_ranking_800.jpg");
            } else if (view.equals(this.image2Button)) {
                new DownloadFileFromURL(this).execute("http://image.itmedia.co.jp/nl/articles/1801/15/miya_180113usagikochokocho01.jpg");
            }
            this.downloading = false;
        }
    }

    @Override
    public void succesfully(Bitmap bitmap) {
        this.imageView.setImageBitmap(bitmap);
        this.progressBar.setVisibility(View.GONE);
        this.downloading = true;
    }
}
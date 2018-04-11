package com.example.ryota.androidtest19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        recyclerView.addItemDecoration(new DividerItemDecoration(10));

        ArrayList<IconModel> iconList = new ArrayList<>();

        iconList.add(new IconModel(getResources().getDrawable(R.drawable.no0), "no0"));
        iconList.add(new IconModel(getResources().getDrawable(R.drawable.no1), "no1"));
        iconList.add(new IconModel(getResources().getDrawable(R.drawable.no2), "no2"));
        iconList.add(new IconModel(getResources().getDrawable(R.drawable.no3), "no3"));
        iconList.add(new IconModel(getResources().getDrawable(R.drawable.no4), "no4"));
        iconList.add(new IconModel(getResources().getDrawable(R.drawable.no5), "no5"));
        iconList.add(new IconModel(getResources().getDrawable(R.drawable.no6), "no6"));
        iconList.add(new IconModel(getResources().getDrawable(R.drawable.no7), "no7"));

        IconListRecyclerViewAdapter adapter = new IconListRecyclerViewAdapter(iconList);

        //setting adapter to recycler
        recyclerView.setAdapter(adapter);
    }

}
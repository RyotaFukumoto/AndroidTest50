package com.example.ryota.androidtest18;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView recyclerViewAdapter;


        private ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.list = new ArrayList<>();
        this.list.add("00000000000\n0000\n\n0000000000\n\n00000\n\n\n0000000000\n0000000000000000000000000000000000000000000000");
        this.list.add("1\n1\n1\n1\n1");
        this.list.add("222\n2" );
        this.list.add("333\n33\n33");
        this.list.add("4\n444\n4444\n44\n44" );
        this.list.add("55\n55\n555" );

        RecyclerView recyclerView1 = findViewById(R.id.casarealRecyclerView);
        CasarealRecycleViewAdapter adapter = new CasarealRecycleViewAdapter(this.createDataset());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView1.setAdapter(adapter);
    }
    private List<RowData> createDataset() {
        List<RowData> dataList = new ArrayList<>();
        @SuppressLint("Recycle") TypedArray typedArray = getApplicationContext().getResources().obtainTypedArray(R.array.thumbnail);

        for (int i = 0; i < this.list.size(); i++) {
            RowData rowData = new RowData();

            rowData.setImage(typedArray.getDrawable(i));
            rowData.setTitle(this.list.get(i));
            dataList.add(rowData);
        }
        return dataList;
    }
}


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

    private List<String> getListData() {
        ArrayList<String> list = new ArrayList<>();
        list.add("00000000" +
                "000000");
        list.add("11111" +
                "1111111");
        list.add("2222" +
                "22222222");
        list.add("3333333" +
                "333333");
        list.add("444444444444" +
                "444444");
        list.add("5555555" +
                "55555555");

        return list;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView1 = findViewById(R.id.casarealRecyclerView);
        CasarealRecycleViewAdapter adapter = new CasarealRecycleViewAdapter(this.createDataset());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView1.setAdapter(adapter);
    }
    private List<RowData> createDataset(){
        List<RowData> dataList = new ArrayList<>();
        @SuppressLint("Recycle") TypedArray typedArray = getApplicationContext().getResources().obtainTypedArray(R.array.thumbnail);

        for (int i = 0;i < getListData().size();i++) {
            RowData rowData = new RowData();

            rowData.setImage(typedArray.getDrawable(i));
        }

    }
}

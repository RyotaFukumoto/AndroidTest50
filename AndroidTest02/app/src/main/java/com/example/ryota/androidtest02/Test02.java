package com.example.ryota.androidtest02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Test02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test02);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("abc");
        arrayList.add("def");
        Log.d("LogOutPut01","ArrayList = " + arrayList);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("One","1");
        hashMap.put("Ten","10");
        Log.d("LogOutPut02","HashMap = " + hashMap);
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("abc");
        hashSet.add("def");
        Log.d("LogOutPut03","HashSet = " + hashSet);

    }
}

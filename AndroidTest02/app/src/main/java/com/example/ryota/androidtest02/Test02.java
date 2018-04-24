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
        Log.d("LogOutPut01",arrayList.get(0));
        Log.d("LogOutPut02",arrayList.get(1));
        
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("One","1");
        hashMap.put("One","1");
        hashMap.put("One","1");
        hashMap.put("Ten","10");
        hashMap.put("Ten","10");
        Log.d("LogOutPut03",hashMap.get("One"));
        Log.d("LogOutPut04",hashMap.get("Ten"));

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("a");
        hashSet.add("a");
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        hashSet.add("c");
        for(String a:hashSet) {
            Log.d("LogOutPut05", a);
        }
    }
}

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
<<<<<<< HEAD
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
=======
        for(int i = 0; i < arrayList.size();i ++) {
            Log.d("LogOutPut01", "ArrayList = " + arrayList.get(i));
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("One","1");
        hashMap.put("Five","5");
        hashMap.put("Five","6");
        hashMap.put("Ten","10");


        Log.d("LogOutPut02","HashMap1 = " + hashMap.get("One"));
        Log.d("LogOutPut03","HashMap2 = " + hashMap.get("Five"));
        Log.d("LogOutPut04","HashMap3 = " + hashMap.get("Ten"));
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("a");
        hashSet.add("a");
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("b");
        hashSet.add("c");

        Log.d("LogOutPut05", "HashSet1 = " + hashSet.contains("a"));
        Log.d("LogOutPut06", "HashSet2 = " + hashSet.contains("b"));
        Log.d("LogOutPut07", "HashSet3 = " + hashSet.contains("c"));
>>>>>>> AndroidTest12

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

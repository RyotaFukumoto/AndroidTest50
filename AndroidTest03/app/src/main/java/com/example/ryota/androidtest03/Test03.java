  package com.example.ryota.androidtest03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

  public class Test03 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ifOutput();
        ifElseOutput();
        elseifOutPut();
        operator();
        whileOutPut();
        dowhileOutPut();
        forOutput();
        forEachOutPut();
        switchOutPut();
    }
    private void ifOutput(){

        if ( 1 == 1 ){
            Log.i("LogOutPut01","1です");
        }
    }
    private void ifElseOutput(){

        if (2 == 1){
            Log.i("LogOutPut02", "1です");
        }else {
            Log.i("LogOutPut03","1では無いです" );
        }
    }
    private void elseifOutPut(){
        int i = 2;
        if (i == 1){
            Log.i("LogOutPut04","1です");
        } else if (i == 2) {
            Log.i("LogOutPut05", "2です");
        }

    }
    private void operator(){
        int numone = 1;
        int numtwo = 2;
        int result = numone < numtwo ? numone : numtwo;
        String str = String.valueOf(result);
        Log.i("LogOutPut07","大きい値は " + str);
    }
    private void whileOutPut(){
        int i = 0;
        while (i < 3){
            i++;
        }
        Log.i("LogOutPut08","whileNum = " + i);

    }
    private void dowhileOutPut(){
        Integer i = 0;
        do{
            i++;
        }while (i < 3);
        Log.i("LogOutPut10"," " + i);
    }
    private void forOutput(){

        for (int i = 0;i < 3;i++){
            Log.i("LogOutPut11"," " + i + " 回目");
        }

    }
    private void forEachOutPut(){
        ArrayList<String> arrayList = (ArrayList<String>) Arrays.asList("AA","BB","CC");

        for (String str :arrayList) {
            Log.i("LogOutPut12", "  " + str);
        }
    }

    private void switchOutPut(){
        int num = 3;
        switch (num){
            case 1:
                Log.i("LogOutPut13","値は1です");
                break;
            case 2:
                Log.i("LogOutPut14","値は2です");
                break;
            default:
                Log.i("LogOutPut15","値は1,2ではありません");
        }
    }
}

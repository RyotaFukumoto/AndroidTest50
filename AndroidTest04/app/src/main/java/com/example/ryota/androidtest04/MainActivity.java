package com.example.ryota.androidtest04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Account account1 = new Account("太郎",25,"男性","Swift");
        Account account2 = new Account("花子",24,"女性","java");

        account1.ProfileOutPut();
        account2.ProfileOutPut();

    }


}
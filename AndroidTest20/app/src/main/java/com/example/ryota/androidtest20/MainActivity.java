package com.example.ryota.androidtest20;

<<<<<<< HEAD
import android.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

=======
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.example.ryota.androidtest20.R.id;
import com.example.ryota.androidtest20.R.layout;
>>>>>>> AndroidTest20


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_main);
=======
        setContentView(layout.activity_main);
>>>>>>> AndroidTest20
        setViews();
    }

    private void setViews() {
<<<<<<< HEAD
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
=======
        FragmentManager manager = getSupportFragmentManager();
        ViewPager viewPager = (ViewPager) findViewById(id.viewPager);
>>>>>>> AndroidTest20
        ExampleFragmentPagerAdapter adapter = new ExampleFragmentPagerAdapter(manager);
        viewPager.setAdapter(adapter);

    }
<<<<<<< HEAD
   ;
=======
>>>>>>> AndroidTest20
}





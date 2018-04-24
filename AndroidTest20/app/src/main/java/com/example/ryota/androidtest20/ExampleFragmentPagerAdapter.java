package com.example.ryota.androidtest20;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.TextView;

class ExampleFragmentPagerAdapter extends FragmentPagerAdapter {
    private TextView textView;
    ExampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Nullable
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ExampleFragment.newInstance(android.R.color.holo_blue_bright, "1/3");
            case 1:
                return ExampleFragment.newInstance(android.R.color.holo_green_light, "2/3");
            case 2:
                return ExampleFragment.newInstance(android.R.color.holo_red_dark, "3/3");
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    public TextView getTextView() {
        return this.textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}

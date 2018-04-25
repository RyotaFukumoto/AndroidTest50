package com.example.ryota.androidtest20;

<<<<<<< HEAD
=======
import android.R.color;
import android.support.annotation.Nullable;
>>>>>>> AndroidTest20
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.TextView;

<<<<<<< HEAD
public class ExampleFragmentPagerAdapter extends FragmentPagerAdapter {
    TextView textView;
    public ExampleFragmentPagerAdapter(FragmentManager fm) {
=======
class ExampleFragmentPagerAdapter extends FragmentPagerAdapter {
    private TextView textView;
    ExampleFragmentPagerAdapter(FragmentManager fm) {
>>>>>>> AndroidTest20
        super(fm);

    }

<<<<<<< HEAD
=======
    @Nullable
>>>>>>> AndroidTest20
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
<<<<<<< HEAD

                return ExampleFragment.newInstance(android.R.color.holo_blue_bright,"1/3");
            case 1:
                return ExampleFragment.newInstance(android.R.color.holo_green_light,"2/3");
            case 2:
                return ExampleFragment.newInstance(android.R.color.holo_red_dark,"3/3");
=======
                return ExampleFragment.newInstance(color.holo_blue_bright, "1/3");
            case 1:
                return ExampleFragment.newInstance(color.holo_green_light, "2/3");
            case 2:
                return ExampleFragment.newInstance(color.holo_red_dark, "3/3");
>>>>>>> AndroidTest20
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

<<<<<<< HEAD
=======
    public TextView getTextView() {
        return this.textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
>>>>>>> AndroidTest20
}

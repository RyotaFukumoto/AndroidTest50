package com.example.ryota.androidtest21;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class OriginalFragmentPagerAdapter extends FragmentPagerAdapter {

    private final CharSequence[] tabTitles = {"タブ1", "タブ2"};

    OriginalFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.tabTitles[position];
    }

    @Nullable
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Main1Fragment();
            case 1:
                return new Main2Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.tabTitles.length;
    }
}
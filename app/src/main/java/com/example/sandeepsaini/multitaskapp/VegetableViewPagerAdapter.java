package com.example.sandeepsaini.multitaskapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Sandeep Saini on 8/13/2018
 */
public class VegetableViewPagerAdapter extends FragmentStatePagerAdapter {

    private static int TAB_COUNT = 2;

    public VegetableViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return VegetableFragment.newInstance();
            case 1:
                return FruitFragment.newInstance();
            default:
                return null;
        }
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return VegetableFragment.TITLE;
            case 1:
                return FruitFragment.TITLE;
        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }
}

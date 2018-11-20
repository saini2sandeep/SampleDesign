package com.example.sandeepsaini.multitaskapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Sandeep Saini on 11/12/2018
 */
public class BottomNavViewPagerAdapter extends FragmentStatePagerAdapter {

    public BottomNavViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            SampleHomeFragment homeFragment = SampleHomeFragment.newInstance();
            return homeFragment;
        } else if (position == 1) {
            SampleDashboardFragment sampleDashboardFragment = SampleDashboardFragment.newInstance();
            return sampleDashboardFragment;
        } else if (position == 2) {
            SampleForumFragment sampleForumFragment = SampleForumFragment.newInstance();
            return sampleForumFragment;
        } else if (position == 3) {
            SampleEmailFragment sampleEmailFragment = SampleEmailFragment.newInstance();
            return sampleEmailFragment;
        } else
            return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}

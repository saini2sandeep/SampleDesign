package com.example.sandeepsaini.multitaskapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sandeep Saini on 8/13/2018
 */
public class VegitableFragment extends Fragment {

    @BindView(R.id.notice_board_tabs)
    TabLayout noticeBoardTabs;
    @BindView(R.id.notice_board_viewpager)
    ViewPager noticeBoardViewPager;

    VegetableViewPagerAdapter vegetableViewPagerAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vegitable, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setUpTabs();
    }

    public static VegitableFragment newInstance() {
        VegitableFragment fragment = new VegitableFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private void setUpTabs() {
        vegetableViewPagerAdapter = new VegetableViewPagerAdapter(getChildFragmentManager());
        noticeBoardViewPager.setAdapter(vegetableViewPagerAdapter);
        noticeBoardViewPager.setOffscreenPageLimit(2);
        noticeBoardTabs.setupWithViewPager(noticeBoardViewPager);
        noticeBoardTabs.setSelectedTabIndicatorColor(getResources().getColor(R.color.textColorOrangeYellow));
    }

}

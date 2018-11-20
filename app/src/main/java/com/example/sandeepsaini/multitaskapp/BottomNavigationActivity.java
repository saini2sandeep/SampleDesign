package com.example.sandeepsaini.multitaskapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BottomNavigationActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    @BindView(R.id.toolbar_title_tv)
    TextView toolBarTitleTV;

    @BindView(R.id.view_pager)
    UnScrollViewPager bottomNavViewPager;
    @BindView(R.id.navigation)
    BottomNavigationView bottomNavigation;

    private BottomNavViewPagerAdapter bottomNavViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottam_navigation);
        ButterKnife.bind(this);

        toolBarTitleTV.setText("Bottom Navigation");

        setUpBottomNavViewPager();

        /*
        Uncomment this line to disable the shifting animation in the bottom navigation view
         */
//        BottomNavigationViewHelper.disableShiftMode(bottomNavigation);

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setUpBottomNavViewPager() {
        bottomNavViewPagerAdapter = new BottomNavViewPagerAdapter(getSupportFragmentManager());
        bottomNavViewPager.setOffscreenPageLimit(0);
        bottomNavViewPager.setAdapter(bottomNavViewPagerAdapter);
        bottomNavViewPager.setOnPageChangeListener(this);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    bottomNavViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    bottomNavViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_forum:
                    bottomNavViewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_email:
                    bottomNavViewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

    @OnClick(R.id.toolbar_back_button_iv)
    void toolbarBackButtonClick(View view) {
        finish();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

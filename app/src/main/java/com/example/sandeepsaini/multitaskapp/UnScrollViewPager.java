package com.example.sandeepsaini.multitaskapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Sandeep Saini on 11/12/2018
 */
public class UnScrollViewPager extends ViewPager {
    private boolean canScroll = false;

    public UnScrollViewPager(@NonNull Context context) {
        super(context);
    }

    public UnScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return canScroll;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return canScroll;
    }
}

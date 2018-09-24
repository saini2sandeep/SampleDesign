package com.example.sandeepsaini.multitaskapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Sandeep Saini on 9/24/2018
 */
public class StoryViewPagerAdapter extends PagerAdapter {
    private Context context;
    LayoutInflater layoutInflater;
    ArrayList<String> imageUrlList;



    public StoryViewPagerAdapter(Context context, ArrayList<String> imageUrlList){
        this.context = context;
        this.imageUrlList = imageUrlList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return imageUrlList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((ConstraintLayout) object);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.item_multi_image_show, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.image_view);
        Glide.with(context).load(imageUrlList.get(position)).into(imageView);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout) object);
    }
}

package com.example.sandeepsaini.multitaskapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePageActivity extends AppCompatActivity implements StoriesAdapter.StoryListener {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    int previousState;

    int currentVisiblePosition = 0;
    int previousVisiblePosition = 0;
    LinearLayoutManager linearLayoutManager;
    StoriesAdapter storiesAdapter;
    private ArrayList<Stories> storiesArrayList = new ArrayList<>();
    String imageUrl = "";

    int imagePosition;
    int itemCount;
    ArrayList<String> viewPagerImagesList;
    int screenWidth;

    int rightScroll = 0;
    int leftScroll = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ButterKnife.bind(this);


        prepareData();

        findScreenSize();

        setDataToUI();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                currentVisiblePosition = linearLayoutManager.findLastVisibleItemPosition();
                previousVisiblePosition = linearLayoutManager.findFirstVisibleItemPosition();
                imagePosition = currentVisiblePosition;
                super.onScrollStateChanged(recyclerView, newState);

//                viewPager.setCurrentItem(currentVisiblePosition,true);

//                if (currentVisiblePosition == itemCount - 1)
//                    previousVisiblePosition = 0;
//                if (currentVisiblePosition != previousVisiblePosition) {
//                    if (storiesArrayList.get(imagePosition).getImageArrayList() != null &&
//                            storiesArrayList.get(imagePosition).getImageArrayList().size() > 0) {
//                        imageUrl = storiesArrayList.get(imagePosition).getImageArrayList().get(0);
//                    }
//                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                Log.d("Sandy", "Dx : " + dx);
                Log.d("Sandy", "Dy : " + dy);

                





//                if(dx>130 || dx<-130){
//                    viewPager.setCurrentItem(currentVisiblePosition,true);
//                }
//                else if(dx > 0)
//                viewPager.scrollBy(dx+5, dy);
//                else
//                viewPager.scrollBy(dx-5,dy);

//                if (dx > 20) {
//                    rightScroll = 0;
//                    rightScroll = dx + 16;
//                    viewPager.scrollBy(rightScroll, dy);
//                } else if (dx < -20) {
//                    leftScroll = 0;
//                    leftScroll = dx - 16;
//                    viewPager.scrollBy(leftScroll, dy);
//                }
            }
        });
    }

    private void setDataToUI() {
        recyclerView.setHasFixedSize(true);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        storiesAdapter = new StoriesAdapter(this, storiesArrayList, this, screenWidth);
        itemCount = storiesAdapter.getItemCount();

        getViewPagerImages();

        StoryViewPagerAdapter storyViewPagerAdapter = new StoryViewPagerAdapter(this, viewPagerImagesList);
        viewPager.setAdapter(storyViewPagerAdapter);

        recyclerView.setAdapter(storiesAdapter);
        viewPager.setOffscreenPageLimit(viewPagerImagesList.size());

    }

    private void prepareData() {
        Stories stories;

        ArrayList<String> urlArrayList;
        String imageUrlString[] = getResources().getStringArray(R.array.image_urls);
        String textListString[] = getResources().getStringArray(R.array.dummy_data);
        for (int i = 0; i < 8; i++) {
            stories = new Stories();
            String storyName = textListString[i];
            stories.setStoryName(storyName);
            urlArrayList = new ArrayList<>();
            for (int j = i; j < 8; j++) {
                urlArrayList.add(imageUrlString[j]);
            }
            stories.setImageArrayList(urlArrayList);
            storiesArrayList.add(stories);
        }

    }

    private void getViewPagerImages() {
        viewPagerImagesList = new ArrayList<>();
        for (int i = 0; i < storiesArrayList.size(); i++) {
            if (storiesArrayList.get(i).getImageArrayList() != null && storiesArrayList.get(i).getImageArrayList().size() > 0) {
                viewPagerImagesList.add(storiesArrayList.get(i).getImageArrayList().get(0));
            }
        }
    }

    @Override
    public void onStoryScroll(String imageUrl) {
        if (!TextUtils.isEmpty(imageUrl)) {
        }
    }

    private void findScreenSize() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        if (this.getWindowManager() != null) {
            this.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        }
//        int height = displaymetrics.heightPixels;
        screenWidth = displaymetrics.widthPixels;
    }
}

/*
        https://homepages.cae.wisc.edu/~ece533/images/airplane.png
        https://homepages.cae.wisc.edu/~ece533/images/arctichare.png
        https://homepages.cae.wisc.edu/~ece533/images/barbara.png
        https://homepages.cae.wisc.edu/~ece533/images/boat.png
        https://homepages.cae.wisc.edu/~ece533/images/boat.png
        https://homepages.cae.wisc.edu/~ece533/images/mountain.png
        https://homepages.cae.wisc.edu/~ece533/images/girl.png
        https://homepages.cae.wisc.edu/~ece533/images/fruits.png
        https://homepages.cae.wisc.edu/~ece533/images/tulips.png
        https://homepages.cae.wisc.edu/~ece533/images/peppers.png
        */
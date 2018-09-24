package com.example.sandeepsaini.multitaskapp;

import java.util.ArrayList;

/**
 * Created by Sandeep Saini on 9/17/2018
 */
public class Stories {

    public Stories() {
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public ArrayList<String> getImageArrayList() {
        return imageArrayList;
    }

    public void setImageArrayList(ArrayList<String> imageArrayList) {
        this.imageArrayList = imageArrayList;
    }

    private String storyName;
    private ArrayList<String> imageArrayList;
}

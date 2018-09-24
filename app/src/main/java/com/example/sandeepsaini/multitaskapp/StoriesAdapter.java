package com.example.sandeepsaini.multitaskapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sandeep Saini on 9/17/2018
 */
public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.StoriesViewHolder> {

    public interface StoryListener {
        void onStoryScroll(String imageUrl);
    }

    private Context context;
    private ArrayList<Stories> storiesArrayList;
    private StoryListener storyListener;
    private int previousHolderPosition;
    private int screenWidth;

    public StoriesAdapter(Context context, ArrayList<Stories> storiesArrayList, StoryListener storyListener,int screenWidth) {
        this.context = context;
        this.storiesArrayList = storiesArrayList;
        this.storyListener = storyListener;
        this.screenWidth = screenWidth;
    }

    @NonNull
    @Override
    public StoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoriesAdapter.StoriesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_stories, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesViewHolder holder, int position) {
        holder.setViewData(storiesArrayList.get(position), holder.getAdapterPosition());
    }

    @Override
    public int getItemCount() {
        return storiesArrayList == null ? 0 : storiesArrayList.size();
    }

    public class StoriesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view)
        TextView textView;
        @BindView(R.id.image_view)
        ImageView imageView;
        @BindView(R.id.more_tv)
        TextView moreTV;

        public StoriesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            if (screenWidth != 0) {
                android.view.ViewGroup.LayoutParams params = itemView.getLayoutParams();
                params.width = (int) ((screenWidth * 3.4) / 4);
                itemView.setLayoutParams(params);
            }
        }

        public void setViewData(Stories stories, int position) {
            if (stories.getImageArrayList() != null && stories.getImageArrayList().size() > 0) {
                previousHolderPosition = position;
//                if (previousHolderPosition != position) {
//                    storyListener.onStoryScroll(stories.getImageArrayList().get(0));
//                }
                Glide.with(context).load(stories.getImageArrayList().get(0)).into(imageView);
            }
            textView.setText(stories.getStoryName());

            textView.post(new Runnable() {
                @Override
                public void run() {
                    int lineCount = textView.getLineCount();
                    Log.d("Sandy", "Number of lines : " + lineCount);
                    if (lineCount > 4)
                        moreTV.setVisibility(View.VISIBLE);
                    else
                        moreTV.setVisibility(View.GONE);
                    // Use lineCount here
                }
            });

        }
    }


    public String getImageUrl(int position) {
        String url = storiesArrayList.get(position).getImageArrayList().get(0);
        return url;
    }

}

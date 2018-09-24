package com.example.sandeepsaini.multitaskapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sandeep Saini on 8/13/2018
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    private Context context;

    public FruitAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FruitViewHolder(LayoutInflater.from(context).inflate(R.layout.item_fruit, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class FruitViewHolder extends RecyclerView.ViewHolder {

        public FruitViewHolder(View itemView) {
            super(itemView);
        }
    }
}

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
public class VegetableAdapter extends RecyclerView.Adapter<VegetableAdapter.VegetableViewHolder> {

    private Context context;

    public VegetableAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public VegetableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VegetableViewHolder(LayoutInflater.from(context).inflate(R.layout.item_vegetable, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VegetableViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class VegetableViewHolder extends RecyclerView.ViewHolder {

        public VegetableViewHolder(View itemView) {
            super(itemView);
        }
    }
}

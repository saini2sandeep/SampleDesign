package com.example.sandeepsaini.multitaskapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sandeep Saini on 8/13/2018
 */
public class VegetableFragment extends Fragment {
    public static final String TITLE = "Vegetables";


    @BindView(R.id.vegetable_rv)
    RecyclerView vegetableRV;

    public static VegetableFragment newInstance() {
        VegetableFragment fragment = new VegetableFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vegetable, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        vegetableRV.setHasFixedSize(true);
        vegetableRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        VegetableAdapter vegetableAdapter = new VegetableAdapter(getContext());
        vegetableRV.setAdapter(vegetableAdapter);


    }
}

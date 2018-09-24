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
public class FruitFragment extends Fragment {
    public static final String TITLE = "Fruits";

    @BindView(R.id.fruit_rv)
    RecyclerView fruitRV;

    public static FruitFragment newInstance() {
        FruitFragment fragment = new FruitFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fruit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        fruitRV.setHasFixedSize(true);
        fruitRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        VegetableAdapter vegetableAdapter = new VegetableAdapter(getContext());
        fruitRV.setAdapter(vegetableAdapter);
    }
}

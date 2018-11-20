package com.example.sandeepsaini.multitaskapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Sandeep Saini on 8/16/2018
 */
public class HomeFragment extends Fragment {


    @BindView(R.id.text_view)
    TextView textView;
    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.button)
    Button button;


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        editText.setText("5");

        setData();
    }

    private void setData() {

//        extView.setText(String.valueOf(textView.getText().toString()*0.002)
        String value = editText.getText().toString().trim();

        if (!TextUtils.isEmpty(value)) {
            int result = (Integer.parseInt(value)) * 3;

//            int result1 = result * 3;
            textView.setText(String.valueOf((Float.parseFloat(value)) * 0.02));
        }
    }


    @OnClick(R.id.button)
    void buttonClick(View view) {

//        AlertUtils alertUtils = new AlertUtils(getContext(), new AlertUtils.AlertDialogListener() {
//            @Override
//            public void onClick(int a) {
//                if (a == 1) {
//                    // Do your work on Positive button click
//                } else {
//                    // Do your work on Negative button click
//                }
//            }
//        });
//        alertUtils.ShowAlertWithTwoButtons("Alert Dialog", "Alert Dialog Description ", "Positive", "Negative");
    }
}

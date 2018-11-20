package com.example.sandeepsaini.multitaskapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sandeepsaini.multitaskapp.bottom_nav.DrawerActivity;
import com.example.sandeepsaini.multitaskapp.imageSelect.ImageActivity;
import com.example.sandeepsaini.multitaskapp.roundImage.RoundImageActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_back_button_iv)
    ImageView toolbarBackButtonIV;
    @BindView(R.id.toolbar_title_tv)
    TextView toolbarTitleTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbarBackButtonIV.setVisibility(View.GONE);
        toolbarTitleTV.setText("Sample Designs");
    }

    @OnClick(R.id.button_bottom_nav)
    void bottomNavClick(View view) {
        Intent intent = new Intent(MainActivity.this, BottomNavigationActivity.class);
        this.startActivity(intent);
    }

    @OnClick(R.id.button_bottom_nav_with_drawer)
    void bottomNavWithDrawerClick(View view) {
        Intent intent = new Intent(MainActivity.this, DrawerActivity.class);
        this.startActivity(intent);
    }

    @OnClick(R.id.button_alert_dialog)
    void buttonAlertDialogClick(View view) {
        final AlertUtils alertUtils = new AlertUtils(MainActivity.this, new AlertUtils.AlertDialogListener() {
            @Override
            public void onClick(int a) {
                if (a == 1) {
                    // Do your work on Positive button click
                } else {
                    // Do your work on Negative button click
                }
            }
        });
        alertUtils.showAlertWithTwoButtons("Alert Dialog", "Alert Dialog Description ", "Positive", "Negative");
    }

    @OnClick(R.id.button_select_image)
    void bottomSelectImageClick(View view) {
        Intent intent = new Intent(MainActivity.this, ImageActivity.class);
        this.startActivity(intent);
    }

    @OnClick(R.id.button_circle_image)
    void bottomCircleImageClick(View view) {
        Intent intent = new Intent(MainActivity.this, RoundImageActivity.class);
        this.startActivity(intent);
    }

}

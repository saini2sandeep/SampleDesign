package com.example.sandeepsaini.multitaskapp.roundImage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sandeepsaini.multitaskapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RoundImageActivity extends AppCompatActivity {


    @BindView(R.id.toolbar_title_tv)
    TextView toolBarTitleTV;
    @BindView(R.id.rounded_image_view)
    RoundedImageView roundedImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_image);
        ButterKnife.bind(this);

        toolBarTitleTV.setText("Rounded ImageView");

        roundedImageView.setImageDrawable(getDrawable(R.drawable.sample_image));
    }


    @OnClick(R.id.toolbar_back_button_iv)
    void toolbarBackButtonClick(View view) {
        finish();
    }

}


package com.example.sandeepsaini.multitaskapp.imageSelect;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sandeepsaini.multitaskapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageViewActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_title_tv)
    TextView toolBarTitleTV;
    @BindView(R.id.image_view)
    ImageView imageView;


    private Bitmap bitmap;
    private String uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        ButterKnife.bind(this);

        toolBarTitleTV.setText("Selected Image Preview");

        unBundleData();

    }

    private void unBundleData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            bitmap = bundle.getParcelable("BitmapImage");
            uri = bundle.getString("ImageUri");

            if (bitmap != null)
                imageView.setImageBitmap(bitmap);
            else
                Glide.with(this).load(uri).into(imageView);
        }
    }

    @OnClick(R.id.toolbar_back_button_iv)
    void toolbarBackButtonClick(View view) {
        finish();
    }

}

package com.example.sandeepsaini.multitaskapp.imageSelect;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sandeepsaini.multitaskapp.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;

public class ImageActivity extends AppCompatActivity {

    private static final int CAMERA_RESULT_CODE = 100;
    private static final int GALLERY_RESULT_CODE = 101;

    private static final int CAMERA_REQUEST_CODE = 200;
    private static final int GALLERY_REQUEST_CODE = 201;


    @BindView(R.id.toolbar_title_tv)
    TextView toolBarTitleTV;
    @BindView(R.id.camera_tv)
    TextView cameraTV;
    @BindView(R.id.gallery_tv)
    TextView galleryTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);

        toolBarTitleTV.setText("Selected Image Source");
    }


    @OnClick(R.id.camera_tv)
    void cameraTvClick(View view) {
        if (EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA)) {
            processCameraImage();
        } else {
            EasyPermissions.requestPermissions(this, "Camera permissions are mandatory to click pictures",
                    CAMERA_RESULT_CODE, Manifest.permission.CAMERA);
        }
    }


    @OnClick(R.id.gallery_tv)
    void galleryTvClick(View view) {
        if (EasyPermissions.hasPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            processGalleryImage();
        } else {
            EasyPermissions.requestPermissions(this, "Storage permissions are mandatory to click pictures",
                    GALLERY_RESULT_CODE, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
    }

    private void processGalleryImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),
                GALLERY_REQUEST_CODE);
    }


    private void processCameraImage() {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);

//        File photoFile = null;
//        try {
//            photoFile = createImageFile();
//        } catch (IOException ex) {
//            // Error occurred while creating the File
////            Timber.tag(TAG).e(ex.getMessage());
//        }
//
//        if (photoFile != null) {
//            Uri photoURI = FileProvider.getUriForFile(this,
//                    "com.example.sandeepsaini.multitaskapp.fileprovider",
//                    photoFile);
//            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
//            startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
//        }
    }


    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_NCONNECT_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );
        return image;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CAMERA_REQUEST_CODE) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                Intent intent = new Intent(this, ImageViewActivity.class);
                intent.putExtra("BitmapImage", photo);
                startActivity(intent);
            } else if (requestCode == GALLERY_REQUEST_CODE) {
                if (data.getData() != null) {
                    Uri imageUri = data.getData();
                    Intent intent = new Intent(this, ImageViewActivity.class);
                    intent.putExtra("ImageUri", imageUri.toString());
                    startActivity(intent);
                }
            }
        }
    }

    @OnClick(R.id.toolbar_back_button_iv)
    void toolbarBackButtonClick(View view) {
        finish();
    }

}

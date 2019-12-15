package com.example.testglide.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.testglide.R;
import com.example.testglide.domain.ImageURL;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

public class ImageDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        PhotoView mImageView = findViewById(R.id.image);

        final String imageUrl = getIntent().getStringExtra("foto");

        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(mImageView);


    }

}

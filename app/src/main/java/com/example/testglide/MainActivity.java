package com.example.testglide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.testglide.adapters.DataAdapter;
import com.example.testglide.domain.ImageURL;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        recyclerView = findViewById(R.id.recyclerView);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        ArrayList imageUrlList = prepareData();
        DataAdapter dataAdapter = new DataAdapter(getApplicationContext(), imageUrlList);
        recyclerView.setAdapter(dataAdapter);

    }

    private ArrayList prepareData() {

        String imageUrls[] = {
                "https://images.unsplash.com/photo-1576078766417-80f4b730120c?ixlib=rb-1.2.1&auto=format&fit=crop&w=1292&q=80",
                "https://images.unsplash.com/photo-1576208260328-cc47418da608?ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80",
                "https://images.unsplash.com/photo-1576080971617-5b789d9bcee4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=749&q=80",
                "https://images.unsplash.com/photo-1576235789670-28a9c8e950b8?ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"};

        ArrayList imageUrlList = new ArrayList<>();
        for (int i = 0; i < imageUrls.length; i++) {
            ImageURL imageUrl = new ImageURL();
            imageUrl.setImageURL(imageUrls[i]);
            imageUrlList.add(imageUrl);
        }
        Log.d("MainActivity", "List count: " + imageUrlList.size());
        return imageUrlList;

    }

}

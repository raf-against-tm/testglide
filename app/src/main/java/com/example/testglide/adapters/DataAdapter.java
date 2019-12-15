package com.example.testglide.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.testglide.R;
import com.example.testglide.activities.ImageDetailActivity;
import com.example.testglide.domain.ImageURL;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<ImageURL> imageUrls;
    private Context context;

    public DataAdapter(Context context, ArrayList<ImageURL> imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;

    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    /**
     * gets the image url from adapter and passes to Glide API to load the image
     *
     * @param viewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        Glide.with(context).load(imageUrls.get(i).getImageURL()).into(viewHolder.img);

        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ImageDetailActivity.class);
                intent.putExtra("foto", imageUrls.get(i).getImageURL());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;

        public ViewHolder(View view) {
            super(view);
            img = view.findViewById(R.id.imageView);
        }
    }
}

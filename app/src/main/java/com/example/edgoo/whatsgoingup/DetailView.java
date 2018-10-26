package com.example.edgoo.whatsgoingup;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailView extends AppCompatActivity {
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rocket_detail);
//              GETS AND SETS ROCKET NAME FROM DATA
        String placeName = getIntent().getStringExtra("place_name");
        TextView name = findViewById(R.id.rocket_name);
        name.setText(placeName);
//              GETS AND SETS ROCKET IMAGE FROM DATA
        String rocketImage = getIntent().getStringExtra("rocket_image");
        ImageView rocket_Image = findViewById(R.id.rocket_image_detail);
        Picasso.with(mContext)
                .load(rocketImage)
                .into(rocket_Image);
//              GETS AND SETS ROCKET START WINDOW FROM DATA
        String start = getIntent().getStringExtra("window_start");
        TextView start_view = findViewById(R.id.window_start);
        start_view.setText(start);
//              GETS AND SETS ROCKET END WINDOW FROM DATA
        String end = getIntent().getStringExtra("window_start");
        TextView end_view = findViewById(R.id.window_end);
        end_view.setText(end);
//              GETS AND SETS ROCKET LOCATION FROM DATA
        String loc = getIntent().getStringExtra("location");
        TextView location = findViewById(R.id.location);
        location.setText(loc);
    }
}

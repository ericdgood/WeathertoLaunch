package com.example.edgoo.whatsgoingup;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailView extends AppCompatActivity{


        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.rocket_detail);

            getIncomingIntent();


        }

    private void getIncomingIntent(){

        String placeName = getIntent().getStringExtra("place_name");

        setItemInfo(placeName);
    }


    private void setItemInfo(String placeName){

        TextView name = findViewById(R.id.rocket_name);
        name.setText(placeName);
    }
    }

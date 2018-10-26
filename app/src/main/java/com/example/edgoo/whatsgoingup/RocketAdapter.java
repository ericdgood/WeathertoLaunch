package com.example.edgoo.whatsgoingup;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.edgoo.whatsgoingup.Utilities.RocketInfo;
import com.squareup.picasso.Picasso;

public class RocketAdapter extends RecyclerView.Adapter<RocketAdapter.ViewHolder> {

    private RocketInfo[] mRockets;
    private final Context mContext;

    RocketAdapter(Context context, RocketInfo[] rockets) {
        mContext = context;
        mRockets = rockets;
    }

    @NonNull
    @Override
    public RocketAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rocket_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RocketAdapter.ViewHolder holder, final int position) {
        holder.rocketName.setText(mRockets[position].getRocket());
        holder.location.setText(mRockets[position].getLocation());
        holder.windowStart.setText(mRockets[position].getWindowStart());
        Picasso.with(mContext)
                .load(mRockets[position].getRocketImage())
                .into(holder.rocketImage);



        holder.rocketImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, DetailView.class);
                intent.putExtra("place_name", mRockets[position].getRocket());
                intent.putExtra("rocket_image", mRockets[position].getRocketImage());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (null == mRockets) return 0;
        return mRockets.length;
    }



    public void setRocketData(RocketInfo[] rocketData) {
        this.mRockets = rocketData;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView rocketName;
        TextView windowStart;
        TextView location;
        ImageView rocketImage;
        LinearLayout rocketDetailLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            rocketName = itemView.findViewById(R.id.rocket_name);
            windowStart = itemView.findViewById(R.id.window_start);
            location = itemView.findViewById(R.id.location);
            rocketImage = itemView.findViewById(R.id.rocket_image);
            rocketDetailLayout = itemView.findViewById(R.id.summary_layout);
        }
    }
}
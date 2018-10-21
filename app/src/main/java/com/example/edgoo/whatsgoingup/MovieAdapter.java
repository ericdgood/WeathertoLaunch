package com.example.edgoo.whatsgoingup;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.edgoo.whatsgoingup.Utilities.MoviesInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private MoviesInfo[] mMovies;
    private final Context mContext;

    MovieAdapter(Context context, MoviesInfo[] movies) {
        mContext = context;
        mMovies = movies;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rocket_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.ViewHolder holder, final int position) {
        holder.rocketName.setText(mMovies[position].getRocket());
        holder.location.setText(mMovies[position].getLocation());
        holder.windowStart.setText(mMovies[position].getWindowStart());
//        holder.windowEnd.setText(mMovies[position].getWindowEnd());
        Picasso.with(mContext)
                .load(mMovies[position].getRocketImage())
                .into(holder.rocketImage);

        holder.rocketImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, DetailView.class);
                intent.putExtra("place_name", mMovies[position].getRocket());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (null == mMovies) return 0;
        return mMovies.length;
    }


    //    SETS MOVIE POSTERS
    public void setMovieData(MoviesInfo[] movieData) {
        this.mMovies = movieData;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView rocketName;
        TextView windowStart;
        TextView location;
        TextView windowEnd;
        ImageView rocketImage;
        LinearLayout rocketDetailLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rocketName = itemView.findViewById(R.id.rocket_name);
            windowStart = itemView.findViewById(R.id.window_start);
            location = itemView.findViewById(R.id.location);
//            windowEnd = itemView.findViewById(R.id.window_end);
            rocketImage = itemView.findViewById(R.id.rocket_image);
            rocketDetailLayout = itemView.findViewById(R.id.summary_layout);
        }
    }
}
package com.example.edgoo.whatsgoingup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edgoo.whatsgoingup.Utilities.MoviesInfo;

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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rocketName = itemView.findViewById(R.id.rocket_name);
        }
    }
}
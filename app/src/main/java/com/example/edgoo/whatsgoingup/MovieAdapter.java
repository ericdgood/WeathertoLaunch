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

public class MovieAdapter extends BaseAdapter {

    private MoviesInfo[] mMovies;
    private final Context mContext;

    MovieAdapter(Context context, MoviesInfo[] movies) {
        mContext = context;
        mMovies = movies;
    }

    @Override
    public int getCount() {
        if (null == mMovies) return 0;
        return mMovies.length;
    }

    @Override
    public Object getItem(int position) {
        if (mMovies == null || mMovies.length == 0) {
            return null;
        }

        return mMovies[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView rocketName;

        if (convertView == null) {
            rocketName = new TextView(mContext);
        } else {
            rocketName = (TextView) convertView;
        }

        rocketName.setText(mMovies[position].getRocket());
        
        return rocketName;
    }

    //    SETS MOVIE POSTERS
    public void setMovieData(MoviesInfo[] movieData) {
        this.mMovies = movieData;
        notifyDataSetChanged();
    }
}
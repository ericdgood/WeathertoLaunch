package com.example.edgoo.whatsgoingup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;
import android.widget.TextView;

import com.example.edgoo.whatsgoingup.Utilities.FetchMovieData;
import com.example.edgoo.whatsgoingup.Utilities.MoviesInfo;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter mMovieAdapter;
    MoviesInfo[] mMovies;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mMovieAdapter = new MovieAdapter(this, mMovies);
        recyclerView.setAdapter(mMovieAdapter);

        loadMovieData();
    }

    private void loadMovieData() {
        new FetchMovieData(mMovieAdapter).execute();

    }
}

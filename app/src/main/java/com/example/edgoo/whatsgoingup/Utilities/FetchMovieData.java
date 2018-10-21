package com.example.edgoo.whatsgoingup.Utilities;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;


import com.example.edgoo.whatsgoingup.MovieAdapter;

import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import static android.content.ContentValues.TAG;

public class FetchMovieData extends AsyncTask<String, Void, MoviesInfo[]> {


    private final MovieAdapter mMovieAdapter;

    public FetchMovieData (MovieAdapter movieAdapter) {
        mMovieAdapter = movieAdapter;
    }

    @Override
    protected MoviesInfo[] doInBackground(String... strings) {

        URL movieUrl = null;
        try {
            movieUrl = getApiUrl();
            Log.d(TAG, "doInBackground: " + movieUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            assert movieUrl != null;
//                BUILDS MOVIEDB URL INTO STRING URL
            Log.d(TAG, "doInBackground pre fetch: " + movieUrl);
            String jsonresponse = FetchJson.getResponseFromHttpUrl(movieUrl);
            Log.d(TAG, "doInBackground: " + jsonresponse);
//                PARES MOVIEDB URL
            return ParseMoviedb.parseMovieJson(jsonresponse);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private URL getApiUrl() throws MalformedURLException {
//        https://api.aerisapi.com/forecasts/32920?filter=1hr&limit=999&client_id=HVptD2sYYxVqQ883K7Bkq&client_secret=u56EL25cFJ9GACs6oVTL2PgPBLYd9lkasSFTzxdl

            final String MOVIEDB_URL = "https://launchlibrary.net/1.4/launch";
        Uri baseUri = Uri.parse(MOVIEDB_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();
//        uriBuilder.appendQueryParameter("api_key", API_KEY_PARAM);
//        uriBuilder.appendQueryParameter("language", "en-US");
//        uriBuilder.appendQueryParameter("page", "1");

        Log.d(TAG, "getApiUrl: " + baseUri.toString());
        return new URL(uriBuilder.toString());
    }

    @Override
    protected void onPostExecute(MoviesInfo[] movieData) {
        Log.d(TAG, "onPostExecute: " + Arrays.toString(movieData));
        mMovieAdapter.setMovieData(movieData);
    }
}
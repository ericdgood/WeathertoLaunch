package com.example.edgoo.whatsgoingup.Utilities;

import android.net.Uri;
import android.os.AsyncTask;


import com.example.edgoo.whatsgoingup.RocketAdapter;

import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchRocketData extends AsyncTask<String, Void, RocketInfo[]> {


    private final RocketAdapter mRocketAdapter;

    public FetchRocketData(RocketAdapter rocketAdapter) {
        mRocketAdapter = rocketAdapter;
    }

    @Override
    protected RocketInfo[] doInBackground(String... strings) {

        URL movieUrl = null;
        try {
            movieUrl = getApiUrl();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            assert movieUrl != null;
//                BUILDS ROCKET URL INTO STRING URL
            String jsonresponse = FetchJson.getResponseFromHttpUrl(movieUrl);

//                PARSE ROCKET URL
            return ParseRocketdb.parseRocketJson(jsonresponse);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private URL getApiUrl() throws MalformedURLException {
            final String rocketDataUrl = "https://us-central1-whatsgoingup-spaceapschallenge.cloudfunctions.net/LoadLaunches";
        Uri baseUri = Uri.parse(rocketDataUrl);
        Uri.Builder uriBuilder = baseUri.buildUpon();
        return new URL(uriBuilder.toString());
    }

    @Override
    protected void onPostExecute(RocketInfo[] movieData) {
        mRocketAdapter.setRocketData(movieData);
    }
}
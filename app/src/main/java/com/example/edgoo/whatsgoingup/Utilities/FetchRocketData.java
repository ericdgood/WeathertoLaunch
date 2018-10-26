package com.example.edgoo.whatsgoingup.Utilities;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;


import com.example.edgoo.whatsgoingup.R;
import com.example.edgoo.whatsgoingup.RocketAdapter;

import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchRocketData extends AsyncTask<String, Void, RocketInfo[]> {


    private final RocketAdapter mRocketAdapter;
    @SuppressLint("StaticFieldLeak")
    private final View mLoadIndicator;

    public FetchRocketData(RocketAdapter rocketAdapter, View loadingIndicator) {
        mRocketAdapter = rocketAdapter;
        mLoadIndicator = loadingIndicator;
    }

    @Override
    protected RocketInfo[] doInBackground(String... strings) {

        URL rocketUrl = null;
        try {
            rocketUrl = getApiUrl();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            assert rocketUrl != null;
//                BUILDS ROCKET URL INTO STRING URL
            String jsonresponse = FetchJson.getResponseFromHttpUrl(rocketUrl);

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
    protected void onPostExecute(RocketInfo[] rocketData) {
        mRocketAdapter.setRocketData(rocketData);
        mLoadIndicator.setVisibility(View.GONE);
    }
}
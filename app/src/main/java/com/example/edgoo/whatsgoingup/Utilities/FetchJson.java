package com.example.edgoo.whatsgoingup.Utilities;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static android.content.ContentValues.TAG;

class FetchJson {

    public static String getResponseFromHttpUrl(URL rocketUrl) throws IOException {
        Log.d(TAG, "doInBackground fetch: " + rocketUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) rocketUrl.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

}

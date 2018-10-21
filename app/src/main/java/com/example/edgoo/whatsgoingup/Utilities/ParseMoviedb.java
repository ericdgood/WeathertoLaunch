package com.example.edgoo.whatsgoingup.Utilities;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Arrays;

import static android.content.ContentValues.TAG;

class ParseMoviedb {

    public static MoviesInfo[] parseMovieJson(String jsonResponse) throws JSONException {

//          CREATES JSON OBJECT WITH JSON STRING
        JSONArray mainJsonObject = new JSONArray(jsonResponse);
        MoviesInfo[] movie = new MoviesInfo[mainJsonObject.length()];


//                 LOOPS THROUGH EACH MOVE ARRAY RESULT
        for (int i = 0; i < mainJsonObject.length(); i++) {

            movie[i] = new MoviesInfo();

//                CREATES A CURRENT MOVIE OBJECT
            JSONObject currentMovie = mainJsonObject.getJSONObject(i);

//            GETS OVERVIEW OF MOVIE
            movie[i].setRocket(currentMovie.getString("name"));
        }
        return movie;
    }

//    EXAMPLE OF A MOVIE ARRAY

// {
//  "launches": [
//    {
//      "id": 1636,
//      "name": "Soyuz 2.1B | Lotos-S1",
//      "windowstart": "2018-10-25 00:00:00",
//      "windowend": "2018-10-25 00:00:00",
//      "net": "October 25, 2018 00:00:00 UTC",
//      "status": 2,
//      "tbdtime": 1,
//      "tbddate": 0,
//      "probability": -1,
//      "changed": "2018-10-14 13:01:00",
//      "lsp": "193"
//    },
}

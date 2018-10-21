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
//            GETS OVERVIEW OF MOVIE
            movie[i].setWindowStart(currentMovie.getString("windowstart"));
//            GETS OVERVIEW OF MOVIE
            JSONObject locArr = currentMovie.getJSONObject("location");
            movie[i].setLocation(locArr.getString("name"));
//            GETS OVERVIEW OF MOVIE
            movie[i].setWindowEnd(currentMovie.getString("windowend"));
//            GETS OVERVIEW OF MOVIE
            JSONObject properties = currentMovie.getJSONObject("rocket");
            movie[i].setRocketImage(properties.getString("imageURL"));
        }
        return movie;
    }

}

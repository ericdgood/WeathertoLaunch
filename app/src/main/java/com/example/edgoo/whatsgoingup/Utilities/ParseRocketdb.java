package com.example.edgoo.whatsgoingup.Utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseRocketdb {

    public static RocketInfo[] parseRocketJson(String jsonResponse) throws JSONException {

//          CREATES JSON OBJECT WITH JSON STRING
        JSONArray mainJsonObject = new JSONArray(jsonResponse);
        RocketInfo[] rocket = new RocketInfo[mainJsonObject.length()];


//                 LOOPS THROUGH EACH MOVE ARRAY RESULT
        for (int i = 0; i < mainJsonObject.length(); i++) {

            rocket[i] = new RocketInfo();

//                CREATES A CURRENT MOVIE OBJECT
            JSONObject currentRocket = mainJsonObject.getJSONObject(i);

//            GETS OVERVIEW OF MOVIE
            rocket[i].setRocket(currentRocket.getString("name"));
//            GETS OVERVIEW OF MOVIE
            rocket[i].setWindowStart(currentRocket.getString("windowstart"));
//            GETS OVERVIEW OF MOVIE
            JSONObject locArr = currentRocket.getJSONObject("location");
            rocket[i].setLocation(locArr.getString("name"));
//            GETS OVERVIEW OF MOVIE
            rocket[i].setWindowEnd(currentRocket.getString("windowend"));
//            GETS OVERVIEW OF MOVIE
            JSONObject properties = currentRocket.getJSONObject("rocket");
            rocket[i].setRocketImage(properties.getString("imageURL"));
        }
        return rocket;
    }

}

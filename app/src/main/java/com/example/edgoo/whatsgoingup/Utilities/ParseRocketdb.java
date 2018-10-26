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

            JSONObject currentRocket = mainJsonObject.getJSONObject(i);

            rocket[i].setRocket(currentRocket.getString("name"));
            rocket[i].setWindowStart(currentRocket.getString("windowstart"));
            JSONObject locArr = currentRocket.getJSONObject("location");
            rocket[i].setLocation(locArr.getString("name"));
            rocket[i].setWindowEnd(currentRocket.getString("windowend"));
            JSONObject properties = currentRocket.getJSONObject("rocket");
            rocket[i].setRocketImage(properties.getString("imageURL"));
        }
        return rocket;
    }

}

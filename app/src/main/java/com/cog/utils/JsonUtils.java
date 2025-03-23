package com.cog.utils;

import org.json.JSONObject;

public class JsonUtils {

    public static JSONObject convertJSONStringtoJSONObject(String jsonString) {
        // Convert JSON String to JSONObject
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject;
    }
}

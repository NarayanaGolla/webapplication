package com.cog.utils;
import org.json.*;

public class JsonUtils {

    public static String convertStringToJsonParser(String stringJson) throws JSONException {

        JSONObject json = new JSONObject(stringJson);
        return json.toString();
    }
}

package com.cog.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GsonUtils {

    public static String readData(String filepath) throws IOException, JSONException {

        // Read JSON file as String
        String content = new String(Files.readAllBytes(Paths.get("login.json")));

        // Parse String to JSONObject
        JSONObject jsonObject = new JSONObject(content);

        return jsonObject.toString();
    }
}

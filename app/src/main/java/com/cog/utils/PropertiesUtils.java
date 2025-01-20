package com.cog.utils;

import java.util.*;
import java.util.stream.Collectors;

public class PropertiesUtils {

    public static Map<String, Object> convertPropertiesToMap(Properties properties) {
        Map<String, Object> map = new HashMap<>();

        Set<Object> keys = properties.keySet(); // Get all keys

        for (Object key : keys) {
            map.put(key.toString(), properties.get(key)); // Add each key-value pair to the map
        }

        return map;
    }

    public static Map<String, Object> convertPropertiesToMapLatest(Properties properties) {
        return properties.entrySet().stream() // Convert entrySet to stream
                .collect(Collectors.toMap(
                        entry -> entry.getKey().toString(), // Key as String
                        Map.Entry::getValue // Value remains the same
                ));
    }
}

package com.cog.utils;

import com.cog.dom.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.List;

public class ObjectMapperutils {

    // Wildcard method to convert JSON array string to list of any object type
    public static <T> List<T> convertJSONarraystringToListOfobjects(String jsonStr, Class<T> clazz) throws JsonProcessingException {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Convert JSON array string to list of T objects
        List<T> objectList = objectMapper.readValue(jsonStr, objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));

        return objectList;
    }

    // Wildcard method to convert JSON array string to list of any object type
    public static User convertJSONstringToobject(String jsonStr) throws JsonProcessingException {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        User user = objectMapper.readerFor(User.class).readValue(jsonStr);
        return user;
    }

    public static String  convertObjectToJsonString(Object object) throws JsonProcessingException {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(object);
        return jsonString;
    }
}

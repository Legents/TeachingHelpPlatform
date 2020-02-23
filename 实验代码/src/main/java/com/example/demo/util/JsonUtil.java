package com.example.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();


    public static String objectToString(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public static <T> T stringToObject(String json,Class<T> object) throws IOException {
        return objectMapper.readValue(json,object);
    }
}

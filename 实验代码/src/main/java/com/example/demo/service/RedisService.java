package com.example.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface RedisService {
    boolean put(String key, Object value, long seconds) throws JsonProcessingException;

    <T> T get(String key, Class<T> clazz) throws IOException;

    String get(String key);
}

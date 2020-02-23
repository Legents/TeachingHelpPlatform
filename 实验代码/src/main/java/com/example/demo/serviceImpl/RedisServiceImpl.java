package com.example.demo.serviceImpl;

import com.example.demo.service.RedisService;
import com.example.demo.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired(required = false)
    private RedisTemplate redisTemplate;

    @Override
    public boolean put(String key, Object value, long seconds) throws JsonProcessingException {
        String json = JsonUtil.objectToString(value);
        if (json == null || json.isEmpty()) return false;
        redisTemplate.opsForValue().set(key, json, seconds, TimeUnit.SECONDS);
        return true;
    }

    @Override
    public <T> T get(String key, Class<T> clazz) throws IOException {
        String json = get(key);
        if (json != null) {
            T t = JsonUtil.stringToObject(json, clazz);
            return t;
        }
        return null;
    }

    public String get(String key){
        Object o = redisTemplate.opsForValue().get(key);
        if (o != null) {
            String json = String.valueOf(o);
            return json;
        }
        return null;
    }
}

package com.example.demo.service;

import com.example.demo.entity.data;
import com.example.demo.entity.user;

import java.util.List;

public interface dataService {
    public data queryById(int id);
    public int insert(data data);
    public int delete(int id);
    public List<data> queryAll(user user);
}

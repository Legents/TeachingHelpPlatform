package com.example.demo.service;

import com.example.demo.entity.classBean;
import com.example.demo.entity.user;

import java.util.List;

public interface userService {
    public List<user> queryAll();
    public List<user> queryListByClass(classBean classBean);
    public user queryById(int id);
    public int insert(user user);
    public int update(user user);
}

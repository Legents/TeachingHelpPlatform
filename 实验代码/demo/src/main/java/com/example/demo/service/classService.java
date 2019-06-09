package com.example.demo.service;

import com.example.demo.entity.classBean;

import java.util.List;

public interface classService {
    public classBean query(classBean classBean);
    public List queryByTeacher(classBean classBean);
    public int insert(classBean classBean);
}

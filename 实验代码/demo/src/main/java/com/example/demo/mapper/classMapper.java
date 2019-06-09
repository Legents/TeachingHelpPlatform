package com.example.demo.mapper;

import com.example.demo.entity.classBean;

import java.util.List;

public interface classMapper {
    public classBean query(classBean classBean);
    public List queryByTeacher(classBean classBean);
    public int insert(classBean classBean);
}

package com.example.demo.service;

import com.example.demo.entity.course;

import java.util.List;

public interface courseService {
   public List<course> queryAll();
   public course queryByNo(course course);
   public int insert(course course);
}

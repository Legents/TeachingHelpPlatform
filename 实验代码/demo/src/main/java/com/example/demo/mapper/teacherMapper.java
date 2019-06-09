package com.example.demo.mapper;

import com.example.demo.entity.user;

import java.util.List;

public interface teacherMapper {
    List<user> queryAll();
    user queryTeacherById(int id);
    int insertTeacher(user user);
    int updateTeacher(user user);
}

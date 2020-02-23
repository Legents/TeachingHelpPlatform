package com.example.demo.mapper;

import com.example.demo.entity.data;
import com.example.demo.entity.user;

import java.util.List;


public interface dataMapper {
    data queryDataById(int id);
    int insertData(data data);
    int deleteData(int id);
    List<data> queryAll(user user);
}

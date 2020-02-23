package com.example.demo.serviceImpl;

import com.example.demo.entity.classBean;
import com.example.demo.entity.user;
import com.example.demo.mapper.teacherMapper;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "teacher")
public class teacherServiceImpl implements userService {
    @Autowired
    private teacherMapper teacherMapper;
    @Override
    public List<user> queryAll() {
        return teacherMapper.queryAll();
    }

    @Override
    public List<user> queryListByClass(classBean classBean) {
        return null;
    }

    @Override
    public user queryById(int id) {
        return null;
    }

    @Override
    public int insert(user user) {
        return teacherMapper.insertTeacher(user);
    }

    @Override
    public int update(user user) {
        return 0;
    }
}

package com.example.demo.serviceImpl;

import com.example.demo.entity.classBean;
import com.example.demo.entity.user;
import com.example.demo.mapper.studentMapper;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "student")
public class studentServiceImpl implements userService {
    @Autowired
    private studentMapper studentMapper;

    @Override
    public List<user> queryAll() {
        return null;
    }

    @Override
    public List<user> queryListByClass(classBean classBean) {
        return studentMapper.queryListByClass(classBean);
    }

    @Override
    public user queryById(int id) {
      // System.out.println("id:"+ studentMapper.queryStudentById(id));
        return studentMapper.queryStudentById(id);
    }

    @Override
    public int insert(user user) {
        return 0;
    }

    @Override
    public int update(user user) {
        return 0;
    }
}

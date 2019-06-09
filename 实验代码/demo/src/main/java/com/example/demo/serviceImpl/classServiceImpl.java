package com.example.demo.serviceImpl;

import com.example.demo.entity.classBean;
import com.example.demo.mapper.classMapper;
import com.example.demo.service.classService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "class")
public class classServiceImpl implements classService {
    @Autowired
    private classMapper classMapper;

    @Override
    public classBean query(classBean classBean) {
        return classMapper.query(classBean);
    }

    @Override
    public List queryByTeacher(classBean classBean) {
        return classMapper.queryByTeacher(classBean);
    }

    @Override
    public int insert(classBean classBean) {
        return classMapper.insert(classBean);
    }
}

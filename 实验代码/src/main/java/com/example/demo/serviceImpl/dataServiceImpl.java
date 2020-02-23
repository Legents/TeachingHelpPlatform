package com.example.demo.serviceImpl;

import com.example.demo.entity.data;
import com.example.demo.entity.user;
import com.example.demo.mapper.dataMapper;
import com.example.demo.service.dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "data")
public class dataServiceImpl implements dataService {

    @Autowired
    private dataMapper dataMapper;


    @Override
    public data queryById(int id) {
        // System.out.println("id:"+ studentMapper.queryStudentById(id));
        return dataMapper.queryDataById(id);
    }

    @Override
    public int insert(data data) {
        return dataMapper.insertData(data);
    }

    @Override
    public int delete(int id) {
        return dataMapper.deleteData(id);
    }

    @Override
    public List<data> queryAll(user user) {
        return dataMapper.queryAll(user);
    }
}

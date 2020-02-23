package com.example.demo.serviceImpl;

import com.example.demo.entity.Class1;
import com.example.demo.mapper.ClassMapper;
import com.example.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "class")
public class ClassServiceImpl implements ClassService {
    @Autowired(required = false)
    private ClassMapper classMapper;
    @Override
    public boolean openClass(Class1 class1) {
        return classMapper.openClass(class1);
    }
}

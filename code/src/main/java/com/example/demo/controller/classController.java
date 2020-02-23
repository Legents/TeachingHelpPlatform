package com.example.demo.controller;

import com.example.demo.config.baseConfig.Result;
import com.example.demo.entity.Class1;
import com.example.demo.service.ClassService;
import com.example.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    @Qualifier("class")
    private ClassService classService;

    @RequestMapping("/openClass")
    public Result openClass(Class1 class1){
        return ResultUtil.success(classService.openClass(class1));
    }
}

package com.example.demo.controller;

import com.example.demo.entity.classBean;
import com.example.demo.service.classService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/class")
public class classController {
    @Autowired
    @Qualifier("class")
    private classService classService;

    @RequestMapping("/query")
    public Map<String,Object> query( classBean classBean){
        Map map=new HashMap<String,Object>();
        classBean=classService.query(classBean);
        map.put("classBean",classBean);
        return map;
    }

    @RequestMapping("/queryByTeacher")
    public Map<String,Object> queryByTeacher(String teacherNo){
        Map map=new HashMap<String,Object>();
        classBean classBean=new classBean();
        classBean.setTeacherNo(teacherNo);
        List<classBean> classList=classService.queryByTeacher(classBean);
        map.put("classList",classList);
        return map;
    }
    @RequestMapping("/add")
    public int add(@RequestBody classBean classBean){
        System.out.println("classBean:"+classBean);
        int i=classService.insert(classBean);
        return i;
    }
}

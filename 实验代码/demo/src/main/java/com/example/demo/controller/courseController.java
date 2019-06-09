package com.example.demo.controller;

import com.example.demo.entity.course;
import com.example.demo.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class courseController {
    @Autowired
    @Qualifier("course")
    private courseService courseSevivce;

    @RequestMapping("/queryAll")
    public Map<String,Object> queryAll(){
        Map map=new HashMap<String,Object>();
        List courseList=courseSevivce.queryAll();
        map.put("courseList",courseList);
        return map;
    }

    @RequestMapping("/query")
   public Map<String,Object> query(String CourseNo){
        Map map=new HashMap<String,Object>();
        course course=new course();
        course.setCourseNo(CourseNo);
        course=courseSevivce.queryByNo(course);
        map.put("course",course);
        return map;
    }
}

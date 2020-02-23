package com.example.demo.serviceImpl;

import com.example.demo.entity.Course;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "course")
public class CourseServiceImpl implements CourseService {
    @Autowired(required = false)
    private CourseMapper courseMapper;
    @Override
    public boolean addCourse(Course course) {
        return courseMapper.addCourse(course);
    }
}

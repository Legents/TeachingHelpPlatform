package com.example.demo.serviceImpl;

import com.example.demo.entity.course;
import com.example.demo.mapper.courseMapper;
import com.example.demo.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "course")
public class courseServiceImpl implements courseService {

    @Autowired
    private courseMapper courseMapper;
    @Override
    public List<course> queryAll() {
        System.out.println("所有课程："+courseMapper.queryAll());
        return courseMapper.queryAll();
    }

    @Override
    public course queryByNo(course course) {
        //System.out.println("CourseNo:"+course.getCourseNo());
        return courseMapper.queryByNo(course);
    }

    @Override
    public int insert(course course) {
        return courseMapper.insert(course);
    }
}

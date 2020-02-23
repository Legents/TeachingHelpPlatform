package com.example.demo.controller;

import com.example.demo.config.baseConfig.Result;
import com.example.demo.config.baseConfig.ResultEnum;
import com.example.demo.config.exceptionHandle.UserException;
import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import com.example.demo.util.ResultUtil;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    @Qualifier("course")
    private CourseService courseService;

    /**
     * 这是一个测试方法，后面会删
     *
     * @return
     */
    @RequestMapping("/test")
    public Result test() {

//        测试异常返回
        throw new UserException(ResultEnum.NOTFOUND_USER);

//        测试返回错误的统一格式
//        1.自定义错误代码和错误信息
//        return ResultUtil.error(-1,"这是一个错误");

//        2.使用ResultEnum枚举类中已经有的错误
//        return ResultUtil.error(ResultEnum.UNKNOW_ERROR);

//        测试返回异常的统一接口
//        Course course1=null;
//        course1.getCourseNo();
//        return null;

//        测试返回成功的统一格式
//        Course course=new Course("1","11","111");
//        return ResultUtil.success(course);
    }

    /**
     * +
     * 添加课程
     *
     * @param course
     * @return
     */
    @RequestMapping("/addCourse")
    public Result addCourse(Course course) {
        return ResultUtil.success(courseService.addCourse(course));
    }

}

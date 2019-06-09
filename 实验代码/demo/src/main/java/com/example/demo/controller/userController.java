
package com.example.demo.controller;

import com.example.demo.entity.classBean;
import com.example.demo.entity.user;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    @Qualifier("student")
    private userService studentService;
    @Autowired
    @Qualifier("teacher")
    private userService teacherService;


    @PostMapping("/login")
    public ModelAndView login(@RequestParam String id,
                              @RequestParam String password, HttpSession session){
        ModelAndView mv=new ModelAndView();
        user user=null;
        List<user> list=teacherService.queryAll();
        System.out.println(list);
        if(list!=null) {
            for (user item : list) {
                if (item.getId().equals(id) && item.getPassword().equals(password)) {
                    session.setAttribute("user",item);
                    mv.setViewName("teacherMain");
                    return mv;
                }
            }
        }
        mv.setViewName("login");
        mv.addObject("msg", "用户名或密码错误");
        return mv;
    }
    @RequestMapping("/queryListByClass")
    public Map<String,Object> queryByClass(@RequestBody classBean classBean){
        System.out.println("classBean:"+classBean);
        Map map=new HashMap<String,Object>();
        List<user> studentList=studentService.queryListByClass(classBean);
        System.out.println(studentList);
        map.put("studentList",studentList);
        return map;
    }
}

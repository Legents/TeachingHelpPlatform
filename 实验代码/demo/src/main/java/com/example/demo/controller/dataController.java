package com.example.demo.controller;

import com.example.demo.entity.data;
import com.example.demo.entity.user;
import com.example.demo.service.dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class dataController {
    @Autowired
    @Qualifier("data")
    private dataService dataService;

    @RequestMapping("/queryAll")
    public Map<String,Object> query(@RequestBody user user){
        System.out.println("user:"+user);
        Map map=new HashMap<String,Object>();
        List<data> dataList=dataService.queryAll(user);
        System.out.println("dataList:"+dataList);
        map.put("dataList",dataList);
        return map;
    }

    @RequestMapping("/queryById")
    public Map<String,Object> queryById(@RequestBody data dataId){
        System.out.println(dataId);
        Map map=new HashMap<String,Object>();
        data data = new data();
        data.setInformationNo(dataId.getInformationNo());
        data=dataService.queryById(dataId.getInformationNo());
        map.put("data",data);
        return map;
    }
    @RequestMapping("/add")
    public int add(@RequestBody data data){
        int i=dataService.insert(data);
        return i;
    }
    @RequestMapping("/delete")
    public int delete(int dataId){
        int i=dataService.delete(dataId);
        return i;
    }
}

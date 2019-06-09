package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class classBean implements Serializable {
    private String classNo;
    private Date courseTime;
    private String teacherNo;
    private String courseNo;
}

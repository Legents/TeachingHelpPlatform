package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class course implements Serializable {
    private String courseNo;
    private String courseName;
    private String courseContent;
}

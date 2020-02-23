package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    String courseNo;
    String courseName;
    String courseDescription;
}

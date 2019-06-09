package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class choicequestion implements Serializable {
    private Integer choicequestionNo;
    private String choicequestionContent;
    private String option;
    private String answer;
    private String classNo;
}

package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class answerChoice implements Serializable {
    private String studentNo;
    private Integer choicequestionNo;
    private String answerChoice;
}

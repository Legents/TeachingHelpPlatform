package com.example.demo.service;

import com.example.demo.entity.choicequestion;
import com.example.demo.entity.classBean;

import java.util.List;

public interface choiceQuestionService {
    public int insert(choicequestion choicequestion);
    public List queryByClass(classBean classBean);
}

package com.example.demo.serviceImpl;

import com.example.demo.entity.choicequestion;
import com.example.demo.entity.classBean;
import com.example.demo.mapper.choiceQuestionMapper;
import com.example.demo.service.choiceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "choiceQuestion")
public class choiceQuestionServiceImpl implements choiceQuestionService {
    @Autowired
    private choiceQuestionMapper choiceQuestionMapper;

    @Override
    public int insert(choicequestion choicequestion) {
        return choiceQuestionMapper.insert(choicequestion);
    }

    @Override
    public List queryByClass(classBean classBean) {
        return choiceQuestionMapper.queryByClass(classBean);
    }
}

package com.example.demo.serviceImpl;

import com.example.demo.entity.answerChoice;
import com.example.demo.mapper.choiceAnswerMapper;
import com.example.demo.service.choiceAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "choiceAnswer")
public class choiceAnswerServiceImpl implements choiceAnswerService {

    @Autowired
    private choiceAnswerMapper choiceAnswerMapper;
    @Override
    public List queryByStudent(answerChoice answerChoice) {
        return choiceAnswerMapper.queryByStudent(answerChoice);
    }
}

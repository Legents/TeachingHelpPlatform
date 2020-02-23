package com.example.demo.entity;


import lombok.Data;

import java.sql.Date;

/**
 * 该类供用户查询时使用
 */
@Data
public class FileToUser {
    String dataName;
    Date uploadTime;
    String classNo;
    String dataForm;
}

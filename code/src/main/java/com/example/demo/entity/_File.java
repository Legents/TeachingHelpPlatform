package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
@Data
@AllArgsConstructor
public class _File {
    String dataName;
    String dataPath;
    Date uploadTime;
    String classNo;
    String dataForm;
    Date publishTime;
}

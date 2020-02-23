package com.example.demo.service;

import com.example.demo.entity.FileToUser;
import com.example.demo.entity._File;

import java.util.List;

public interface FileService {
    boolean upFile(_File file);
    int deleteFile(int fileId);
    List<FileToUser> queryFileByType(String classNo, String fileType);
    List<FileToUser> queryAllFile(String classNo);

    //根据文件的编号获取存取路径
    String getPath(int fileId);
}

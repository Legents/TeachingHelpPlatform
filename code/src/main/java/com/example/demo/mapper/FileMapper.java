package com.example.demo.mapper;

import com.example.demo.entity.FileToUser;
import com.example.demo.entity._File;

import java.util.List;

public interface FileMapper {
    boolean upFile(_File file);
    int deleteFile(int fileId);
    List<FileToUser> queryFileByType(String classNo, String fileType);
    List<FileToUser> queryAllFile(String classNo);
    String getPath(int fileId);
}

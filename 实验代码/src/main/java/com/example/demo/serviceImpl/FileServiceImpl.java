package com.example.demo.serviceImpl;

import com.example.demo.entity.FileToUser;
import com.example.demo.entity._File;
import com.example.demo.mapper.FileMapper;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "file")
public class FileServiceImpl implements FileService {
    @Resource
    FileMapper fileMapper;
    @Override
    public boolean upFile(_File file) {
        return fileMapper.upFile(file);
    }

    @Override
    public int deleteFile(int fileId) {
        return fileMapper.deleteFile(fileId);
    }

    @Override
    public List<FileToUser> queryFileByType(String classNo, String fileType) {
        return fileMapper.queryFileByType(classNo,fileType);
    }

    @Override
    public List<FileToUser> queryAllFile(String classNo) {
        return fileMapper.queryAllFile(classNo);
    }

    @Override
    public String getPath(int fileId) {
        return fileMapper.getPath(fileId);
    }
}

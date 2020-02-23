package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class FileUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);
    private static String defaultFilePath = "/static/";

    /**
     * 上传一个文件，使用默认文件目录
     * @return
     */
    public static boolean uploadFile(MultipartFile file) throws FileNotFoundException {
        return uploadFile(file, defaultFilePath);
    }

    /**
     * 上传多个文件，使用自定义的文件目录
     * @param file
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    public static boolean uploadFile(MultipartFile file, String filePath) throws FileNotFoundException {
        if (file.isEmpty()) {
            return false;
        }
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        //获取系统资源文件所在目录
        String s = ResourceUtil.getResourcePath();
        File dest = new File(s + filePath + fileName);
        System.out.println(dest);

        try {
            file.transferTo(dest);
            LOGGER.info(fileName + " 上传成功");
        } catch (IOException e) {
            LOGGER.error(fileName + " 上传失败！");
            e.printStackTrace();
            return false;
        }
        return true;
    }

}

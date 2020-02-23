package com.example.demo.controller;

import com.example.demo.config.baseConfig.Result;
import com.example.demo.entity.FileToUser;
import com.example.demo.entity._File;
import com.example.demo.service.FileService;
import com.example.demo.util.FileUtil;
import com.example.demo.util.ResourceUtil;
import com.example.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Date;
import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-15 14:04
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    @Qualifier("file")
    private FileService fileService;

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    /**
     * 可以单文件，也可以多文件上传
     *
     * @param files
     * @param classNo 上传至编号对应的班级里
     * @param dataForm 用户上传的资料类型
     * @param publishTime 资料发布时间
     * @return
     * @throws FileNotFoundException
     */
    @PostMapping("/upload")
    @ResponseBody
    public Result upload(@RequestParam("files") MultipartFile[] files, String classNo,
                         String dataForm, java.sql.Date publishTime) throws FileNotFoundException {
        /**
         * test
         */
        System.out.println(classNo+dataForm);
        int length = files.length;
        int successNum = 0;
        for (MultipartFile file : files) {
            boolean result = FileUtil.uploadFile(file);
            if (result == true) {
                String str = file.getOriginalFilename();
                //截取文件名
                String fileName = str.substring(0,str.indexOf("."));
                String filePath = "/static/";
                java.util.Date date = new java.util.Date();
                java.sql.Date uploadTime = new java.sql.Date(date.getTime());
                _File f = new _File(fileName,filePath,uploadTime,classNo,dataForm,publishTime);
                if(fileService.upFile(f))
                    successNum++;
                else
                    continue;
            } else {
                continue;
            }
        }
        String result = String.format("成功上传%d个文件，%d个文件上传失败", successNum, length - successNum);
        return ResultUtil.success(result);
    }

    /**
     * @param response
     * @param fileName 需要下载的文件名称,例如：服务员.png
     * @return
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response, String fileName)
            throws FileNotFoundException, UnsupportedEncodingException {

        if (fileName != null) {
            String path = "static/";
            String resourcePath = ResourceUtil.getResourcePath();
            //设置文件路径，暂时将文件存在static目录中
            String filePath = resourcePath + path + fileName;
            System.out.println(filePath);
            File file = new File(filePath);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                fileName = new String(fileName.getBytes(), "ISO8859-1");
                System.out.println("fileName:  " + fileName);
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * 用于教师撤回资料或学生删除已提交作业重新提交
     * @param fileId 选择删除时传来的资料编号
     * @return
     * 由于是在前端页面直接选择要删除的文件，故不必在删除前检查该文件是否存在
     */
    @PostMapping("/deleteFile")
    public Result deleteFiles(int fileId){
        return ResultUtil.success(fileService.deleteFile(fileId));
    }

    /**
     * 学生按照类型查询资料时调用
     * @param classNo 当前进入的班级编号
     * @param fileType 选取的资料类型
     * @return
     */
    @RequestMapping("/queryFileByType")
    public List<FileToUser> queryFileByType(String classNo, String fileType){
        return fileService.queryFileByType(classNo,fileType);
    }

    /**
     * 用户查询当前班级所有资料
     * @param classNo 当前用户进入的班级编号
     * @return
     */
    @RequestMapping("/queryAllFile")
    public Result queryAllFile(String classNo){
        return ResultUtil.success(fileService.queryAllFile(classNo));
    }

    @RequestMapping("/getPath")
    public Result getPath(int fileId){
        return ResultUtil.success(fileService.getPath(fileId));
    }
}
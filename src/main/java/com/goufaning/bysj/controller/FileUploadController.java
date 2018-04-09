package com.goufaning.bysj.controller;

import com.goufaning.bysj.pojo.Message;
import com.goufaning.bysj.pojo.Status;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@Controller
public class FileUploadController {

    @RequestMapping(value="/upload_file",method= RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if(!file.isEmpty()) {
            //上传文件路径
            String path = "C://file";
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            String filePath = path + File.separator + filename;
            try {
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                return "fail";
            }
            Message msg = new Message();
            msg.setStatus(Status.SUCCESS);
            msg.setStatusMsg("File upload success");
            return "{\"state\":\"success\"}";
        } else {
            Message msg = new Message();
            msg.setStatus(Status.ERROR);
            msg.setError("File is empty");
            return "fail";
        }
    }
}

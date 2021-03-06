package com.goufaning.bysj.controller;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.goufaning.bysj.common.Constant;
import com.goufaning.bysj.common.FileProcessor;
import com.goufaning.bysj.pojo.Literature;
import com.goufaning.bysj.pojo.Message;
import com.goufaning.bysj.pojo.Status;
import com.goufaning.bysj.utils.DataUtil;
import com.goufaning.bysj.utils.NIpirUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@SpringBootApplication
@RestController
public class FileUploadController {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    // 上传文件
    @RequestMapping(value="/upload_file",method= RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile[] files, HttpSession session) {
        String userID = session.getId();
        Message msg = new Message();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            if (!file.isEmpty()) {
                //上传文件名
                String filename = file.getOriginalFilename();
                String filePath = Constant.saveFilePath + File.separator + userID + File.separator + filename;
                File newfile = new File(filePath);
                //判断路径是否存在，如果不存在就创建一个
                if (!newfile.getParentFile().exists()) {
                    newfile.getParentFile().mkdirs();
                }
                //将上传文件保存到一个目标文件当中
                try {
                    file.transferTo(newfile);
                    String content = Files.asCharSource(newfile, Charsets.UTF_8).read();
                    content = DataUtil.getAbstract(content);
                    String result = NIpirUtil.fenci(content);
                    Literature literature = new Literature(userID, filename, content, result);
                    FileProcessor.getInstance().addLiterature(literature);
                    logger.info(filename + "已保存");
                } catch (IOException e) {
                    arr.add(i);
                }
            } else {
                arr.add(i);
            }
        }
        if(arr.size() > 0) {
            msg.setStatus(Status.ERROR);
            msg.setError("文件上传失败");
            msg.setErrorKys(arr);
        } else {
            msg.setStatus(Status.SUCCESS);
            msg.setStatusMsg("文件上传成功");
        }
        logger.info(msg.getStatus().toString());
        return "{}";
    }

    @RequestMapping(value="/delete_all",method= RequestMethod.GET,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deleteAllFile(HttpSession session) {
        String userID = session.getId();
        FileProcessor.getInstance().removeAllLiterature(userID);
        return "{}";
    }

    @RequestMapping(value="/del",method= RequestMethod.GET,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deleteFile(@RequestParam("filename") String filename, HttpSession session) {
        String userID = session.getId();
        FileProcessor.getInstance().removeLiterature(userID, filename);
        return "{}";
    }
}

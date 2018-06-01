package com.goufaning.bysj.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static void deleteFile(String pathname) {
        try{
            File file = new File(pathname);
            if(file.delete()){
                logger.info(file.getName() + " 文件已被删除！");
            }else{
                logger.info("文件删除失败！");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 获取文件夹下所有txt文件名
     * @param file
     * @return
     */
    public static List<String> getFileList(File file) {
        List<String> result = new ArrayList<String>();
        if (!file.isDirectory()) {
            System.out.println(file.getAbsolutePath());
            result.add(file.getAbsolutePath());
        } else {
            File[] directoryList = file.listFiles(new FileFilter() {
                public boolean accept(File file) {
                    if (file.isFile() && file.getName().contains("txt")) {
                        return true;
                    } else {
                        return false;
                    }
                }
            });
            for (int i = 0; i < directoryList.length; i++) {
                result.add(directoryList[i].getPath());
            }
        }
        return result;
    }

}

package com.goufaning.bysj.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 全局常量
 */
@Component
public class Constant {


    public  static String saveFilePath;

    public static String stopDirPath;

    @Value("${file.path}")
    public void setSaveFilePath(String saveFilePath) {
        this.saveFilePath = saveFilePath;
    }

    @Value("${file.stopPath}")
    public void setStopDirPath(String stopDirPath) {
        this.stopDirPath = stopDirPath;
    }
}

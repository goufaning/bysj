package com.goufaning.bysj.common;

public class FileProcessor {

    /** 临时用 */
    public static String filePath = "C:\\Users\\10319\\OneDrive - xinyi\\大学\\毕业设计\\参考论文\\摘要.pdf";

    private static FileProcessor instance = new FileProcessor();

    private FileProcessor(){};

    public static FileProcessor getInstance() {
        return instance;
    }

    public void setFilePath(String path) {
        filePath = path;
    }

    public String getFilePath() {
        return filePath;
    }
}

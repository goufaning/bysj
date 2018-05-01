package com.goufaning.bysj.utils;

import java.util.Properties;

public class LoadLib {

    /**
     * 获取分词dll文件路径，根据不同系统自动选择
     * @return
     */
    public static String getLibPath(){
        Properties properties=System.getProperties();
        StringBuffer sys=new StringBuffer("/libs/");
        String lib="";
        if (properties.get("os.name").toString().toLowerCase().contains("win")) {
            sys.append("win");
            lib="/NLPIR.dll";
        }else {
            sys.append("Linux");
            lib="/libNLPIR.so";
        }
        if (properties.get("os.arch").toString().toLowerCase().contains("86")) {
            sys.append("32");
        }else {
            sys.append("64");
        }
        sys.append(lib);
        return sys.toString();
    }
}

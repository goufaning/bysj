package com.goufaning.bysj.utils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<String> getFileList(File file) {

        List<String> result = new ArrayList<String>();

        if (!file.isDirectory()) {
            System.out.println(file.getAbsolutePath());
            result.add(file.getAbsolutePath());
        } else {
            File[] directoryList = file.listFiles(new FileFilter() {
                public boolean accept(File file) {
                    if (file.isFile() && file.getName().indexOf("txt") > -1) {
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

    public static void main(String[] args) throws IOException {
        String FILE_IN = "C:\\Users\\10319\\Desktop\\format";
        File f = new File(FILE_IN);
        List<String> list = new ArrayList<String>();
        list = getFileList(f);

        System.out.println(list.size());

        for (String l : list) {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(l)), Charset.forName("GBK")));
            StringBuilder sb = new StringBuilder();
            String str;
            while((str = br.readLine()) != null){
                sb.append(str);
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(l)), Charset.forName("UTF-8")));
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
    }

}

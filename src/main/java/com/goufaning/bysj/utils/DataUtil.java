package com.goufaning.bysj.utils;

import java.io.*;
import java.util.*;


public class DataUtil {
    private static String path = (new File("")).getAbsolutePath();
    private static BufferedReader br = null;
    private static BufferedWriter bw = null;
    private static String line_current = null;
    private static String[] words = null;
    private static List<String> word_list = new ArrayList<String>();
    static Map<String, Integer> wordToint = new HashMap<String, Integer>();
    public static int wordCount = 0;
    private static int lowFreq = 1;//低频词
    private static float highFreq = 0.9998f;//高频词
    private static final String regex = ",";
    public static String getTitle(String text) {
        String result = "";
        if (null != text) {
            result = subString(text, "title", " abstract");
        }
        return result;
    }

    public static String getText(String text) {
        String result = "";
        if (null != text) {
            result = subString(text, "text", null);
        }
        return result;
    }

    public static String subString(String str, String strStart, String strEnd) {
        /* 找出指定的2个字符在 该字符串里面的 位置 */
        int strStartIndex = str.indexOf(strStart);
        int strEndIndex = str.length();
        if (null != strEnd) {
            strEndIndex = str.indexOf(strEnd);
        }
        /* index 为负数 即表示该字符串中 没有该字符 */
        if (strStartIndex < 0) {
            return "字符串 :---->" + str + "<---- 中不存在 " + strStart + ", 无法截取目标字符串";
        }
        if (strEndIndex < 0) {
            return "字符串 :---->" + str + "<---- 中不存在 " + strEnd + ", 无法截取目标字符串";
        }
        /* 开始截取 */
        String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
        return result;
    }

    public static void printMap(Map<String, Integer> map) throws IOException {

        bw = new BufferedWriter(new FileWriter(""));

        Set<String> keys = map.keySet();
        writeResult("[" + keys.size() +"]" );
        for (String s : keys) {
            System.out.println("word: " + s +
                    ", times: " + map.get(s));
           // [M] [term_1]:[count] [term_2]:[count] ...  [term_N]:[count]
            writeResult(" [" + s +"]:"+
                    "[" + map.get(s)+"]");
        }
    }

    public static void writeResult(String line) throws IOException {
        try {
            if (bw != null) {
                bw.write(line);
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            closeOutputStream(bw);
        }
    }

    public static void closeOutputStream(BufferedWriter writer) {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void closeInputStream(BufferedReader reader) {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}
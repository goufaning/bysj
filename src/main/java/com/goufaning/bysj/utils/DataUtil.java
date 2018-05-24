package com.goufaning.bysj.utils;

import com.goufaning.bysj.common.FileProcessor;
import com.goufaning.bysj.pojo.Literature;

import java.io.*;
import java.util.*;


public class DataUtil {
    private static BufferedWriter bw = null;

    /**
     * 获取文章标题
     * @param text
     * @return
     */
    public static String getTitle(String text) {
        String result = "";
        if (null != text) {
            result = subString(text, "title:", " abstract");
        }
        return result;
    }

    /**
     * 获取文章内容
     * @param text
     * @return
     */
    public static String getText(String text) {
        String result = "";
        if (null != text) {
            result = subString(text, "text:", null);
        }
        return result;
    }

    /**
     * 获取文章摘要
     * @param text
     * @return
     */
    public static String getAbstract(String text) {
        String result = "";
        if (null != text) {
            result = subString(text, "abstract：", "keyword");
        }
        return result;
    }


    /**
     * 截取strStart和strEnd之间的字符串，若strEnd为空，就是截取到末尾
     * @param str
     * @param strStart
     * @param strEnd
     * @return
     */
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

    /**
     * 统计单词频率
     * @param result
     * @return
     */
    public static Map<String, Integer> statisticalFrequency(String result) {
        result = result.replaceAll("\r|\n|\t|\u0001", " ");
        result = result.replaceAll(" +"," ");
        String[] results = result.split(" ");
        List<String> words = Arrays.asList(results);
        // 去除停用词
        words = ExcludeStopWordUtil.stopWordFilter(words);
        Map<String, Integer> word2Freq = new HashMap<String, Integer>();
        // 统计词频
        for (String word : words) {
            int freq = Collections.frequency(words, word);
            word2Freq.put(word, freq);
        }
        return word2Freq;
    }

    public static void getResult(String userId) throws IOException {
        List<Literature> literatureList = FileProcessor.getInstance().getLiteratureList(userId);
        int wordId = 0;
        Map<String, Integer> word2index = new HashMap<>();
        List<String> words = new LinkedList<>();
        bw = new BufferedWriter(new FileWriter("data/nips/nips.txt"));
        for (Literature literature : literatureList) {
            StringBuilder br = new StringBuilder();
            Map<String, Integer> word2Freq = literature.getWord2freq();
            br.append(word2Freq.size());
            for (String word : word2Freq.keySet()) {
                if (null == word2index.get(word)) {
                    word2index.put(word, wordId);
                    words.add(word);
                    br.append(" " + wordId + ":" + word2Freq.get(word));
                    wordId++;
                } else {
                    int id = word2index.get(word);
                    br.append(" " + id + ":" + word2Freq.get(word));
                }
            }
            writeResult(br.toString() + "\r\n");
        }
        bw = new BufferedWriter(new FileWriter("data/nips/vocab.nips.txt"));
        for (String word : word2index.keySet()) {
            writeResult(word + "\t" + word2index.get(word) + "\r\n");
        }
    }

    public static String codeString(String fileName) {
        BufferedInputStream bin = null;
        String code = null;
        try {
            bin = new BufferedInputStream(new FileInputStream(fileName));
            int p = (bin.read() << 8) + bin.read();
            bin.close();
            switch (p) {
                case 0xefbb:
                    code = "UTF-8";
                    break;
                case 0xfffe:
                    code = "Unicode";
                    break;
                case 0xfeff:
                    code = "UTF-16BE";
                    break;
                default:
                    code = "GBK";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
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

    public static void writeResult(String line) {
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
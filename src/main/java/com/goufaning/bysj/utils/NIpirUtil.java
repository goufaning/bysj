package com.goufaning.bysj.utils;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class NIpirUtil {

    public static Map<String, Integer> fenci(String inputStr) throws UnsupportedEncodingException {
        String argu = "";
        // String system_charset = "GBK";//GBK----0
        String system_charset = "GBK";
        int charset_type = 1;
        // int charset_type = 0;
        // 调用printf打印信息
        int init_flag = NlpirProcessor.CLibrary.Instance.NLPIR_Init(argu.getBytes(system_charset), charset_type, "0".getBytes(system_charset));

        if (0 == init_flag) {
            System.err.println("初始化失败！");
            return null;
        }

        String nativeBytes = null;
        inputStr = inputStr.trim();
        inputStr = inputStr.replaceAll("\r\n","");
        // bPOStagged：判断是否需要词性标注，0为不标记，1为标记，
        nativeBytes = NlpirProcessor.CLibrary.Instance.NLPIR_ParagraphProcess(inputStr, 0);
        String[] result = nativeBytes.split(" ");
        List<String> words = Arrays.asList(result);
        words = ExcludeStopWordUtil.stopWordFilter(words);
        words.remove("");
        Map<String, Integer> word2Freq = new HashMap<String, Integer>();
        for (String word : words) {
            int freq = Collections.frequency(words, word);
            word2Freq.put(word, freq);
        }
        // String keyWord = NlpirProcessor.CLibrary.Instance.NLPIR_GetKeyWords(inputStr, 10,false);

        NlpirProcessor.CLibrary.Instance.NLPIR_Exit();
        return word2Freq;
    }
}

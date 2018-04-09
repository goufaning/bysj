package com.goufaning.bysj.utils;

import java.io.UnsupportedEncodingException;

public class NIpirUtil {

    public static String fenci(String inputStr) throws UnsupportedEncodingException {
        String argu = "";
        // String system_charset = "GBK";//GBK----0
        String system_charset = "GBK";
        int charset_type = 1;
        // int charset_type = 0;
        // 调用printf打印信息
        int init_flag = NlpirTest.CLibrary.Instance.NLPIR_Init(argu.getBytes(system_charset), charset_type, "0".getBytes(system_charset));

        if (0 == init_flag) {
            System.err.println("初始化失败！");
            return null;
        }
        String sInput = "据悉，质检总局已将最新有关情况再次通报美方，要求美方加强对输华玉米的产地来源、运输及仓储等环节的管控措施，有效避免输华玉米被未经我国农业部安全评估并批准的转基因品系污染。";

        String nativeBytes = null;
        nativeBytes = NlpirTest.CLibrary.Instance.NLPIR_ParagraphProcess(inputStr, 3);
        String keyWord = NlpirTest.CLibrary.Instance.NLPIR_GetKeyWords(sInput, 10,false);

        NlpirTest.CLibrary.Instance.NLPIR_Exit();
        return "分词结果"+ nativeBytes + "\n" + "关键词" + keyWord;
    }
}

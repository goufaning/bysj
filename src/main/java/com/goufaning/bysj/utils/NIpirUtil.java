package com.goufaning.bysj.utils;

import java.io.UnsupportedEncodingException;

public class NIpirUtil {

    public static String fenci(String inputStr) {
        String argu = "";
        String system_charset = "GBK";
        int charset_type = 1;
        int init_flag = 0;
        try {
            init_flag = NlpirProcessor.CLibrary.Instance.NLPIR_Init(argu.getBytes(system_charset), charset_type, "0".getBytes(system_charset));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (0 == init_flag) {
            System.err.println("初始化失败！");
        }
        String nativeBytes = null;
        // bPOStagged：判断是否需要词性标注，0为不标记，1为标记，
        nativeBytes = NlpirProcessor.CLibrary.Instance.NLPIR_ParagraphProcess(inputStr, 0);
        NlpirProcessor.CLibrary.Instance.NLPIR_Exit();
        return nativeBytes;
    }
}

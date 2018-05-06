package com.goufaning.bysj.pojo;

import com.goufaning.bysj.utils.DataUtil;

import java.util.Map;
import java.util.UUID;

public class Literature {
   private String vid;

   private String userId;

   private String docName;

   private String docContent;

   private String result;

   private Map<String, Integer> word2freq;

   public Literature(String userId, String docName, String docContent, String result) {
        this.vid = UUID.randomUUID().toString();
        this.userId = userId;
        this.docName = docName;
        this.docContent = docContent;
        this.result = result;
        word2freq = DataUtil.statisticalFrequency(result);
    }



    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocContent() {
        return docContent;
    }

    public void setDocContent(String docContent) {
        this.docContent = docContent;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, Integer> getWord2freq() {
        return word2freq;
    }

    public void setWord2freq(Map<String, Integer> word2freq) {
        this.word2freq = word2freq;
    }

}

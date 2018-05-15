package com.goufaning.bysj.pojo;

import java.util.List;
import java.util.Map;

public class Result {

    private double perplexity;

    private Map<Integer, List<String>> topics;


//    private double gamma;
//
//    private double alpha;
//
//    private int wordNum;
//
//    private int totalWordsNum;
//
//    private int docNum;


    public double getPerplexity() {
        return perplexity;
    }

    public void setPerplexity(double perplexity) {
        this.perplexity = perplexity;
    }

    public Map<Integer, List<String>> getTopics() {
        return topics;
    }

    public void setTopics(Map<Integer, List<String>> topics) {
        this.topics = topics;
    }
}

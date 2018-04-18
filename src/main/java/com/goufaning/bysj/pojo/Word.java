package com.goufaning.bysj.pojo;

public class Word {

    private String text;

    private int weight;

    public Word(String text, int weight) {
        this.text = text;
        this.weight = weight;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "UserGroup [text=" + text + ", weight=" + weight + "]";
    }
}

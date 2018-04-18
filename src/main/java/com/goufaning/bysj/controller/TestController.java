package com.goufaning.bysj.controller;


import com.goufaning.bysj.common.FileProcessor;
import com.goufaning.bysj.pojo.Word;
import com.goufaning.bysj.utils.NIpirUtil;
import com.goufaning.bysj.utils.PDFReader;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @RequestMapping(value="/text",method = RequestMethod.GET)
    public String index(ModelMap model){
        List<Word> word = new LinkedList<Word>();
        String text = PDFReader.getText(FileProcessor.getInstance().getFilePath());
        Map<String, Integer> result = new HashMap<>();
        try {
            result = NIpirUtil.fenci(text);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (String key : result.keySet()) {
            int freq = result.get(key);
            word.add(new Word(key, freq));
        }

//        word.add(new Word("Lorem", 13));
//        word.add(new Word("Ipsum",10));
//        word.add(new Word("Dolor",9));
//        word.add(new Word("Sit",8));
//        word.add(new Word("Amet",6));
//        word.add(new Word("Consectetur",5));
//        word.add(new Word("Adipiscing",7));
//        word.add(new Word("Elit",5));
//        word.add(new Word("Nam et",5));
//        word.add(new Word("Leo",4));
//        word.add(new Word("Pellentesque",3));
//        word.add(new Word("habitant",3));
        JSONArray array = new JSONArray(word);
        model.addAttribute("json", array.toString());
        return "text";
    }
}

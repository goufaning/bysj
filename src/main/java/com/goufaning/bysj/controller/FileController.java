package com.goufaning.bysj.controller;

import com.google.common.base.Strings;
import com.goufaning.bysj.common.FileProcessor;
import com.goufaning.bysj.pojo.Literature;
import com.goufaning.bysj.pojo.Word;
import org.json.JSONArray;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class FileController {
    @RequestMapping(value = "/file", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> file(@RequestParam("fileName") String fileName, HttpSession session) {
        String userID = session.getId();
        Map<String, String> map = new HashMap<String, String>();
        Literature literature = FileProcessor.getInstance().getLiterature(userID, fileName);
        if (null == literature) {
            map.put("content" , "");
        } else {
            map.put("content", literature.getResult());
        }
        List<Word> word = new LinkedList<Word>();
        Map<String, Integer> result = literature.getWord2freq();
        for (String key : result.keySet()) {
            if (Strings.isNullOrEmpty(key)) {
                continue;
            }
            int freq = result.get(key);
            word.add(new Word(key, freq));
        }
        JSONArray array = new JSONArray(word);
        map.put("words", array.toString());
        return map;
    }
}

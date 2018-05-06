package com.goufaning.bysj.controller;


import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.io.Files;
import com.goufaning.bysj.common.FileProcessor;
import com.goufaning.bysj.pojo.Word;
import com.goufaning.bysj.utils.DataUtil;
import com.goufaning.bysj.utils.NIpirUtil;
import org.json.JSONArray;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@Controller
public class TestController {

    @RequestMapping(value="/text",method = RequestMethod.GET)
    public String index(ModelMap model,  HttpSession session) throws IOException {
        List<Word> word = new LinkedList<Word>();
        File file = new File(FileProcessor.getInstance().getFilePath());
        String content = Files.asCharSource(file, Charsets.UTF_8).read();
        String userId = session.getId();
        DataUtil.getResult(userId);
        Map<String, Integer> result = new HashMap<>();

        String fenciResult = NIpirUtil.fenci(DataUtil.getText(content));
        result = DataUtil.statisticalFrequency(fenciResult);

        for (String key : result.keySet()) {
            if (Strings.isNullOrEmpty(key)) {
                continue;
            }
            int freq = result.get(key);
            word.add(new Word(key, freq));
        }
        JSONArray array = new JSONArray(word);
        model.addAttribute("json", array.toString());
        System.out.println(array.toString());
        return "text";
    }
}

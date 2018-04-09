package com.goufaning.bysj.controller;

import com.goufaning.bysj.utils.NIpirUtil;
import com.goufaning.bysj.utils.PDFReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;

@Controller
public class TestController {

    @RequestMapping(value="/text",method = RequestMethod.GET)
    public String index(ModelMap model){
        String text = PDFReader.getText("C:\\Users\\10319\\OneDrive - xinyi\\大学\\毕业设计\\参考论文\\摘要.pdf");

        try {
            text = NIpirUtil.fenci(text);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        model.addAttribute("text",text);
        return "text";
    }
}

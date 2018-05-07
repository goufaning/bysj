package com.goufaning.bysj.controller;

import com.goufaning.bysj.common.FileProcessor;
import com.goufaning.bysj.pojo.Literature;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
@Controller
public class MainController {
    @RequestMapping(value="/main", method=RequestMethod.GET)
    public String toMain(Model model, HttpSession session) {
        String userId = session.getId();
        List<String> fileNames = new LinkedList<>();
        List<Literature> literatureList = FileProcessor.getInstance().getLiteratureList(userId);
        if (null != literatureList && literatureList.size() != 0) {
            for (Literature l : literatureList) {
                fileNames.add(l.getDocName());
            }
        }
        model.addAttribute("filenames", fileNames);
        return "main";
    }


}

package com.goufaning.bysj.controller;


import com.goufaning.bysj.utils.DataUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@SpringBootApplication
@Controller
public class TestController {

    @RequestMapping(value="/text",method = RequestMethod.GET)
    public String index(ModelMap model,  HttpSession session) throws IOException {
        String userId = session.getId();
        DataUtil.getResult(userId);
        return "text";
    }
}

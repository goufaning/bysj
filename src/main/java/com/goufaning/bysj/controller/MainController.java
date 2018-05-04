package com.goufaning.bysj.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@Controller
public class MainController {
    @RequestMapping(value="/main", method=RequestMethod.GET)
    public String toMain() {
        return "main";
    }


}

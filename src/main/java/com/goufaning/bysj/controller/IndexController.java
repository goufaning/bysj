package com.goufaning.bysj.controller;
/**
 * 主页
 */

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@Controller
public class IndexController {
    @RequestMapping(value={"/","/index"}, method=RequestMethod.GET)
    public String index(){
        return "index";
    }
}

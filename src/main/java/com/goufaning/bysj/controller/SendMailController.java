package com.goufaning.bysj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SendMailController {
    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping(value = "/sendmail",method = RequestMethod.POST)
    public String sendMail(@RequestParam("view") String level, @RequestParam("content") String content,
                                        @RequestParam("name") String name, @RequestParam("email") String mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        Map<String, String> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        builder.append("用户姓名:");builder.append(name);builder.append("/n");
        builder.append("用户邮箱:");builder.append(mail);builder.append("/n");
        builder.append("用户评分:");builder.append(level);builder.append("/n");
        builder.append("用户反馈:");builder.append(content);builder.append("/n");
        message.setFrom("1031974286@qq.com");
        message.setTo("1031974286@qq.com");
        message.setSubject("反馈邮件");
        message.setText(builder.toString());
        mailSender.send(message);
        return "index";
    }
}

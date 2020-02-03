package com.chanx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

// 在templates目录下所有页面只能通过@Controller跳转
// 需要模板引擎支持 thymeleaf识别
@Controller
public class IndexController {

    @RequestMapping("/test")
    public String index(Model model) {

        model.addAttribute("msg", "hello, springboot");
        model.addAttribute("msg", "<h1>hello, springboot</h1>");
        model.addAttribute("users", Arrays.asList("aaa", "bbb", "ccc"));
        return "test";
    }
}

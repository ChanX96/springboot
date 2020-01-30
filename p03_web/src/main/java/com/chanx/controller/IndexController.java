package com.chanx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 在templates目录下所有页面只能通过@Controller跳转
// 需要模板引擎支持 thymeleaf识别
@Controller
public class IndexController {

    @RequestMapping("/test")
    public String index() {

        return "test";
    }
}

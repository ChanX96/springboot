package com.chanx.p01_helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自动装配: 支持热部署
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    // 接口：http://localhost:8080/hello/hello
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        // 调用业务，接收前端参数
        return "hello world";
    }
}

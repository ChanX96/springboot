package com.chanx.p01_helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 程序的主入口，不能删也不能改
 * 本身就是组件
 */
@SpringBootApplication
public class P01HelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(P01HelloworldApplication.class, args);
    }

}

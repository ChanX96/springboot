package com.chanx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.chanx.mapper")
public class P06MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(P06MybatisApplication.class, args);
	}

}

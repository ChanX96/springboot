package com.chanx.p02_config;


import com.chanx.p02_config.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class P02ConfigApplicationTests {

	@Autowired
	private Person person;

	@Test
	void contextLoads() {

		System.out.println(person);
	}

}

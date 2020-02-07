package com.chanx;

import com.chanx.pojo.AuthUser;
import com.chanx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringbootApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

        AuthUser user = userService.queryUserByName("root");

        System.out.println(user);
    }

}

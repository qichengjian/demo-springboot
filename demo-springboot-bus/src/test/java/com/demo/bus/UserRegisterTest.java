package com.demo.bus;

import com.demo.bus.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRegisterTest {

    @Autowired
    private UserService userService;

    @Test
    public void test01() {
        userService.register("张三");
        userService.register("王五");
    }
}

package com.demo.mybatisplus;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.demo.mybatisplus.entity.UserDO;
import com.demo.mybatisplus.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

/**
 * @author qichengjian
 * @description UserServiceTest
 * @date 2020/6/3 下午2:31
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test01() {
        UserDO userDO = generate();
        userService.save(userDO);
    }

    @Test
    public void test02() {

        List<UserDO> list = userService.list();
        list.forEach(System.out::println);
        userService.getOne(Wrappers.<UserDO> lambdaQuery().eq(UserDO::getAge, 18));
    }

    private UserDO generate() {
        UserDO userDO = new UserDO();
        Random r = new Random();
        int random = new Random().nextInt(99);
        userDO.setName("Lily" + random )
                .setAge(random)
                .setEmail(r+"@ssss.com");
        return userDO;
    }
}

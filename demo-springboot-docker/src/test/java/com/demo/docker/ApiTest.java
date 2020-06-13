package com.demo.docker;

import com.demo.docker.utils.ApiHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author qichengjian
 * @description ApiTest
 * @date 2020/6/12 上午9:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    @Resource
    private ApiHelper apiHelper;

    @Test
    public void test01() {
        System.out.println(apiHelper.getEnv());
        assert apiHelper.getEnv() == null;
    }
}

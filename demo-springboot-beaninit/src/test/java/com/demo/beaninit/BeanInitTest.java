package com.demo.beaninit;

import com.demo.beaninit.biz.MyBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BeanInitTest {

    @Autowired
    private MyBean myBean;

    @Test
    public void test01() {
        myBean.hello();
    }
}

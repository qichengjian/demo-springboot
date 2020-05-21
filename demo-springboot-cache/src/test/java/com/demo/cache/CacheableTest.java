package com.demo.cache;

import com.demo.cache.service.SkuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheableTest {

    @Autowired
    private SkuService skuService;

    @Test
    public void testFindById() {
        for (int i = 0; i < 5; i++) {
            System.out.println("返回结果：" + skuService.findById(1));
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("返回结果：" + skuService.findById(2));
        }
    }
}

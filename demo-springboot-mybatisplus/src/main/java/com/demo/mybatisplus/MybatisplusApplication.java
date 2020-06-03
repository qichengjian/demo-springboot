package com.demo.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author qichengjian
 * @description MybatisplusApplication
 * @date 2020/6/3 下午1:42
 */
@SpringBootApplication
@MapperScan(basePackages = "com.demo.mybatisplus.mapper")
public class MybatisplusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisplusApplication.class, args);
    }
}

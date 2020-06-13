package com.demo.docker.utils;

import com.demo.docker.service.Holder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author qichengjian
 * @description ApiHelper
 * @date 2020/6/12 上午9:48
 */
@Component
public class ApiHelper {

    @Value("${env}")
    private String env;

    @Resource
    private Holder holder;

    @Bean
    public Holder build() {
        // 在构造方法中引用@Value为null，原因与spring实例化顺序有关，
        // 解决办法: 使用配置类来或获取
        return new Holder(env);
    }

    public String getEnv() {
        return holder.getEnv();
    }
}

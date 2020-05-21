package com.demo.beaninit.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author qichengjian
 */
@Configuration
public class MyBeanNameAware implements BeanNameAware {

    @Override
    public void setBeanName(String s) {
        System.out.println("调用BeanNameAware的setBeanName方法：" +s);
    }
}

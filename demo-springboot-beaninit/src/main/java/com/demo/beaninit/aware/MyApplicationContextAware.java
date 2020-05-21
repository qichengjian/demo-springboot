package com.demo.beaninit.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author qichengjian
 */
@Configuration
public class MyApplicationContextAware implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("调用applicationContextAware的setApplicationContext方法");
        MyApplicationContextAware.applicationContext = applicationContext;
    }
}

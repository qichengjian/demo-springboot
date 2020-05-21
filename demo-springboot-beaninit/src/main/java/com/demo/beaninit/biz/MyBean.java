package com.demo.beaninit.biz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author qichengjian
 */
@Component
public class MyBean {

    private String name;
    private Integer value;


    public MyBean() {
        System.out.println("调用myBean无参构造器");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("调用myBean的setName方法");
    }

    public void setValue(Integer value) {
        this.value = value;
        System.out.println("调用myBean的setValue方法");
    }

    public void hello() {
        System.out.println("调用hello方法");
    }

    @PostConstruct
    public void doInit() {
        System.out.println("调用doInit方法");
    }

    @PreDestroy
    public void doDestroy() {
        System.out.println("调用doDestroy方法");
    }




}

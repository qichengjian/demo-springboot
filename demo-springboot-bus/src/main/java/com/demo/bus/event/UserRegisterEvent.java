package com.demo.bus.event;

import org.springframework.context.ApplicationEvent;

/**
 * 用户注册事件
 * @author qichengjian
 */
public class UserRegisterEvent extends ApplicationEvent {

    private String username;

    public UserRegisterEvent(Object source){
        super(source);
    }

    public UserRegisterEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

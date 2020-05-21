package com.demo.bus.service;

import com.demo.bus.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author qichengjian
 */
@Service
public class MailService implements ApplicationListener<UserRegisterEvent> {

    @EventListener
    public void sendMail(UserRegisterEvent event) {
        System.out.println("给用户发送电子邮件中："+ event.getUsername());
    }

    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println("给用户发送电子邮件中："+ event.getUsername());
    }
}

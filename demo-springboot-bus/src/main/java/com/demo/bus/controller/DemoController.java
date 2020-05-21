package com.demo.bus.controller;

import com.demo.bus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qichengjian
 */
@RestController
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(String name) {
        userService.register(name);
        return "success";
    }
}

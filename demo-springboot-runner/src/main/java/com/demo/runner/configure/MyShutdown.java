package com.demo.runner.configure;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class MyShutdown implements ExitCodeGenerator {

    @PreDestroy
    public void destroy() {
        System.out.println("destroy系统关闭前执行");
    }

    @Override
    public int getExitCode() {
        return 0;
    }
}

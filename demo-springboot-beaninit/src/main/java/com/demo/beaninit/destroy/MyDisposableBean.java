package com.demo.beaninit.destroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qichengjian
 */
@Configuration
public class MyDisposableBean implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean的destroy方法");
    }
}

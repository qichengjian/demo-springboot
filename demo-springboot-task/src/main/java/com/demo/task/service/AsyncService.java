package com.demo.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步任务
 * @author qichengjian
 */
@Service
public class AsyncService {

    /**
     * Async注解会告诉spring这是一个异步方法
     */
    @Async
    public void hello() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据处理中");
    }
}

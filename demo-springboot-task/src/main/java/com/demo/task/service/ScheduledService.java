package com.demo.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author qichengjian
 */
@Service
public class ScheduledService {

    @Scheduled(cron = "* * * * * MON-SAT")
    public void hello() {
        System.out.println("定时执行的方法2223333");
    }
}

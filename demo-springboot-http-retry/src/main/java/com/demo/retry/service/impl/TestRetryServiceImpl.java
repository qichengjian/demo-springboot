package com.demo.retry.service.impl;

import com.demo.retry.service.TestRetryService;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author qichengjian
 * @description TestRetryServiceImpl
 * @date 2020/6/23 下午3:16
 */
@Service
public class TestRetryServiceImpl implements TestRetryService {
    @Override
    @Retryable(value = Exception.class, maxAttempts = 4, backoff = @Backoff(delay = 2000, multiplier = 1.5))
    public int dignifiedTest(int code) throws Exception {
        System.out.println("dignifiedTest被调用，时间："+ LocalDateTime.now());
        if (code==0) {
            throw new Exception("请求不对头!");
        }
        System.out.println("dignifiedTest被调用，情况对头了！");
        return 200;
        //输出结果
//        dignifiedTest被调用，时间：2020-06-23T15:53:39.618
//        dignifiedTest被调用，时间：2020-06-23T15:53:41.620
//        dignifiedTest被调用，时间：2020-06-23T15:53:44.623
//        dignifiedTest被调用，时间：2020-06-23T15:53:49.125
//        回调方法执行！！！
    }

    @Recover
    public int revover(Exception e) {
        System.out.println("回调方法执行！！！");
        return 400;
    }
}

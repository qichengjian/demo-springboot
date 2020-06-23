package com.demo.retry.controller;

import com.demo.retry.service.TestRetryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qichengjian
 * @description TestController
 * @date 2020/6/23 下午3:32
 */
@RestController
public class TestController {

    @Resource
    private TestRetryService retryService;

    @GetMapping("/test")
    public int test(@RequestParam(name = "code") int code) throws Exception{
        return retryService.dignifiedTest(code);
    }
}

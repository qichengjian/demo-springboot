package com.demo.retry.rest;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qichengjian
 * @description RestTemplateUtil
 * @date 2020/6/30 下午3:51
 */
public class RestTemplateUtil {

    /**
     * @description: 手动拼接参数 麻烦 可读性差
     * @author qichengjian
     * @date 2020/6/30 下午4:14
     */
    public static void test01() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        String url = "http://localhost:8092/api";

        HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
        Map<String, Object> maps = Maps.newHashMap();
        maps.put("name", "测试");
        ResponseEntity<String> response = restTemplate.exchange(url + "&name={name}", HttpMethod.GET, requestEntity, String.class, maps);
        System.out.println(response.getBody());
        assert JSONObject.parseObject(response.getBody()).getInteger("code") == 0;
    }

    /**
     * @description: 错误写法，错误的原因是请求后无法获取到参数
     * @author qichengjian
     * @date 2020/6/30 下午4:16
     */
    public static void errorTest01() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        Map<String, String> params = new HashMap<>();
        params.put("name", "测试");

        HttpEntity requestEntity = new HttpEntity<>(requestHeaders);

        String url = "http://localhost:8092/api";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class, params);

        System.out.println(response.getBody());
        assert JSONObject.parseObject(response.getBody()).getInteger("code") == 0;

    }

    /**
     * @description: 正确写法
     * @author qichengjian
     * @date 2020/6/30 下午4:15
     */
    public static void test02() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8092/api";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("name", "测试");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity(headers);
        System.out.println(builder.build().encode().toUriString());
        System.out.println(builder.build().encode().toUri());
        ResponseEntity<String> response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, requestEntity, String.class);

        System.out.println(response.getBody());
        assert JSONObject.parseObject(response.getBody()).getInteger("code") == 0;
    }

    public static void main(String[] args) {
//        test01();
        test02();
    }


}

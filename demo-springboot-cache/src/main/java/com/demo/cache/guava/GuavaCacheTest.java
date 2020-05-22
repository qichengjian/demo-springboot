package com.demo.cache.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * guava cache使用示例
 */
public class GuavaCacheTest {

    public static void main(String[] args) {
        Cache cache = CacheBuilder.newBuilder()
                //数据在多长时间内没有被访问后失效
                .expireAfterAccess(3, TimeUnit.MINUTES)
                //写入多长时间后失效
                .expireAfterWrite(10, TimeUnit.SECONDS)
                //并发更新操作最大数量
                .concurrencyLevel(5)
                //最大容量
                .maximumSize(10)
                // 初始容量
                .initialCapacity(1024)
                //
                .softValues()
                .build();

        cache.put("MVP", "James");

        System.out.println(cache.getIfPresent("MVP"));
    }
}

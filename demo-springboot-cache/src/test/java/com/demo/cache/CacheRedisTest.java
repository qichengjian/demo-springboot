package com.demo.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheRedisTest {

    /**
     * k-v都是对象的
     */
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 操作k-v都是字符串的
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisCacheManager redisCacheManager;


    /**
     * Redis常见的5大数据类型
     * String字符串，List列表，Set集合，Hash散列，ZSet有序集合
     * stringRedisTemplate.opsForValue()[string字符串]
     *  stringRedisTemplate.opsForList()[list集合]
     *  stringRedisTemplate.opsForHash()
     *  stringRedisTemplate.opsForSet()
     *  stringRedisTemplate.opsForZSet()
     *
     *
     */
    @Test
    public void test01() {
        stringRedisTemplate.opsForValue().append("key", "value");
        stringRedisTemplate.opsForValue().set("key", "value");
        stringRedisTemplate.opsForValue().get("key");
        stringRedisTemplate.opsForList().leftPush("myList","1");
        stringRedisTemplate.opsForList().leftPush("myList", "2");
        stringRedisTemplate.opsForList().leftPop("myList");
    }

    /**
     * 测试保存对象
     */
    @Test
    public void test02() {
        /**
         * 默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
         * 保存的对象序号实现序列化接口，jdk序列化的结构直接在redis中看是乱码的，
         * 需要自定义序列化规则
         */
        redisTemplate.opsForValue().set("key", new Object());
        /**
         * 将数据以json的方式保存
         * 1。自己将对象转为json
         * 2。redisTemplate默认的序列化规则，改变默认的序列化规则；
         */
    }

    /**
     * 用手动编码的形式去操作缓存
     * 使用缓存管理器操作得到缓存就可以了
     *
     */
    @Test
    public void test03() {
        /**
         * 获取某个缓存
         */
        Cache cache = redisCacheManager.getCache("student");
        cache.put("student", new Object());

    }


}

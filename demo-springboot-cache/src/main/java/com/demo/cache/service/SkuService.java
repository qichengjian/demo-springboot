package com.demo.cache.service;

import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * CacheConfig用来定义类中方法的缓存cacheNames
 * 方法中的缓存注解就不需要再定义cacheNames或者value
 * 抽取缓存中的公共配置
 * @author qichengjian
 */
@CacheConfig(cacheNames = "student")
@Service
public class SkuService {

    /**
     * 使用默认的concurrentmap来缓存数据
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"}, condition = "#id > 0", unless = "#result == null")
    public Object findById(Integer id) {
        System.out.println("查询id为" + id);
        return id;
    }

    /**
     * 自定义keyGenerator
     *
     * @param id
     * @return
     */
    @Cacheable(value = {"student"}, keyGenerator = "myKeyGenerator")
    public Object getStudent(Integer id) {
        System.out.println("学生id为" + id);
        return id;
    }

    /**
     * CachePut，既调用方法，又更新缓存
     * 修改了数据库的某个数据，同时更新缓存
     * 这里key可以使用#result 或者 #a0 或者 #id
     */
    @CachePut(value = {"student"}, key = "#result")
    public Object updateStudent(Integer id) {
        System.out.println("更新id为" + id);
        return id;
    }

    /**
     * CacheEvict 缓存清除
     * key:指定要删除的数据
     * allEntries=true，指定删除这个缓存中所有的数据
     * beforeInvocation=false,默认在方法执行之后删除缓存，出现异常不会清除缓存
     * beforeInvocation=true,删除缓存在方法执行之前执行，出现异常也会清除缓存
     *
     * @param id
     */
    @CacheEvict(value = {"student"}, key = "#id")
    public void deleteStudent(Integer id) {
        System.out.println("删除id为" + id);
    }

    /**
     * Caching 定义复杂的缓存规则
     *
     * @param name
     * @return
     */
    @Caching(
            cacheable = {@Cacheable(value = "student", key = "#name")},
            put = {@CachePut(value = "student", key = "#name"),
            @CachePut(value = "student", key = "#a0")}

    )
    public Object getStudentByLastName(String name) {
        System.out.println("通过姓氏获取学生：" + name);
        return name;
    }
}

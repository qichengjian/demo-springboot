package com.demo.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.demo.mybatisplus.entity.UserDO;
import com.demo.mybatisplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author qichengjian
 * @description UserTest
 * @date 2020/6/3 下午1:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        System.out.println("----selectAll---");
        List<UserDO> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void test02() {
        UserDO userDO = generate();
        userMapper.insert(userDO);
        test01();
    }

    @Test
    public void test03() {
        // 根据主键查
        UserDO userDO = userMapper.selectById(1);
        System.out.println(userDO);

        // 根据某个条件查
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(UserDO::getName, "Jack");
        System.out.println(userMapper.selectOne(queryWrapper));
        // 只查询指定字段
        QueryWrapper queryWrapper1 = new QueryWrapper();
        queryWrapper1.select("id", "name");
        userMapper.selectList(queryWrapper1).forEach(System.out::println);
        // 根据in范围查
        List<Long> ids = Arrays.asList(1L,2L,3L);
        LambdaQueryWrapper lambdaQueryWrapper = Wrappers.<UserDO>lambdaQuery().in(UserDO::getId, ids);
        userMapper.selectList(lambdaQueryWrapper).forEach(System.out::println);
        // 只查询指定字段
        LambdaQueryWrapper lambdaQueryWrapper1 = Wrappers.<UserDO> lambdaQuery().select(UserDO::getName, UserDO::getId);
        userMapper.selectList(lambdaQueryWrapper1).forEach(System.out::println);
        // 根据某个条件查
        LambdaQueryWrapper lambdaQueryWrapper2 = Wrappers.lambdaQuery(new UserDO().setId(3L));
        userMapper.selectList(lambdaQueryWrapper2).forEach(System.out::println);

    }

    @Test
    public void test04() {
        List<UserDO> users = userMapper.selectList(Wrappers.<UserDO>query().orderByDesc("age"));
        users.forEach(System.out::println);
    }

    private UserDO generate() {
        UserDO userDO = new UserDO();
        Random r = new Random();
        int random = new Random().nextInt(99);
        userDO.setName("Lily" + random )
                .setAge(random)
                .setEmail(random+"@ssss.com");
        return userDO;
    }
}

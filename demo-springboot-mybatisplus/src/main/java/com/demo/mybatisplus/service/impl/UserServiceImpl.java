package com.demo.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.mybatisplus.entity.UserDO;
import com.demo.mybatisplus.mapper.UserMapper;
import com.demo.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author qichengjian
 * @description UserServiceImpl
 * @date 2020/6/3 下午1:52
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

}

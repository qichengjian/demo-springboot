package com.demo.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.mybatisplus.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author qichengjian
 * @description UserMapper
 * @date 2020/6/3 下午1:49
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}

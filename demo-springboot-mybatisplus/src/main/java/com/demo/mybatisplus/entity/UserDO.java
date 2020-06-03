package com.demo.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author qichengjian
 * @description UserDO
 * @date 2020/6/3 下午1:48
 */
@Data
@Accessors(chain = true)
@TableName(value = "user")
public class UserDO {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

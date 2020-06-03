## SpringBoot整合mybatis-plus整合示例
 ### 只使用Mapper CRUD接口
   * 添加依赖 mybatis-plus-boot-starter
   * 配置MapperScan扫描路径到mapper文件夹
   * UserMapper继承BaseMapper
   * UserDO配置表名@TableName
 ### 使用Service CRUD接口
   * 添加扩展依赖 mybatis-plus-extension
   * UserServiceImpl继承ServiceImpl
   * UserService继承IService
 ###实际调用
   * userService.getOne
   * userService.list
   * Wrappers.lambdaQuery(new UserDO().setId(3L))
   * queryWrapper.lambda().eq(UserDO::getName, "Jack");
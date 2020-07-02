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
   
 ###json类型字段操作示例
   * Mysql5.7开始支持json类型的字段
   * 一般来说json分为 jsonObject，jsonArray。两者处理略有区别
   ```
## 查询json字段，结果带引号
select id, JSON_EXTRACT(order_info, '$.companyName') 'companyName' 
from order where  JSON_EXTRACT(order_info, '$.area') is not null limit 1

## 查询json字段，结果带引号
select id,order_info-> '$.companyName' 
from order where  JSON_EXTRACT(order_info, '$.area') is not null limit 1


## 查询json字段，不带引号
select id,order_info->> '$.companyName', order_info
from order where  JSON_EXTRACT(order_info, '$.companyName') = 'ss'

## json查询条件带引号
select id, order_info->'$.area' 'area', order_info
from order where JSON_CONTAINS(order_info,'"ss"', '$.companyName')
   ```

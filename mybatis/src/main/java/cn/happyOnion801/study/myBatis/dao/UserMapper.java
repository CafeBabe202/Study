package cn.happyOnion801.study.myBatis.dao;

import cn.happyOnion801.study.myBatis.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 可以通过注释添加sql语句，直接进行查询，简单查询很方便，但是复杂查询很难受，不建议使用这种方式
 * 如果通过注解进行接口的实现，请通过class的方式进行Mapper的注册
 *
 * #{} 和 ${} 的区别
 * #{} 相当于Statement ，可以很大程度上防止 sql 注入，建议使用
 * ${} 相当于PrePareStatement ，不能防止 sql 注入，不建议使用
 *
 * @Param 作用
 * 用于映射参数名和占位符名，如果有多个参数，在基本变量类型和String前必须使用
 */
public interface UserMapper {
    User getUserByName(String name);

    User getUserByNameLike(String name);

    List<User> getUserList();

    int insertUser(User user);

    int insertUserByMap(Map<String, Object> map);

    @Delete("delete from user where name = #{na}")
    int deleteUserByName(@Param("na") String name);

    int updateUserByName(User user);
}

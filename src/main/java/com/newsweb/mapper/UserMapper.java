package com.newsweb.mapper;

import com.newsweb.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询用户列表
    @Select("SELECT * FROM user")
    public List<User> getAll();

    //通过ID查找用户信息
    @Select("SELECT * FROM user where userID=#{userID} ")
    public User getUserById(int userID);

    @Select("SELECT * FROM user where userName=#{userName} ")
    public User getUserByName(String userName);

    @Select("SELECT * FROM user where userName=#{userName}")
    public User findByName(String name);
    //登录
    @Select(" SELECT * FROM user WHERE userName=#{userName} and userPassword=#{userPassword}")
    public User findUsername(@Param("userName")String userName,@Param("userPassword")String userPassword);

    //注册增加用户
    @Insert("INSERT INTO user (userName,userPassword,sex,Email) VALUES (#{userName},#{userPassword},#{sex},#{Email})")
    public boolean addUser(User user);

    //删除用户
    @Delete("Delete from user where userID=#{userID}")
    public boolean delUser(int userID);

    //修改用户资料
    @Update("Update user set userName=#{userName},userPassword=#{userPassword},sex=#{sex},Email=#{Email} where userId=#{userId}")
    public boolean updateUser(User user);
}

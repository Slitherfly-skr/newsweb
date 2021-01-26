package com.newsweb.service.impl;

import com.newsweb.entity.User;
import com.newsweb.mapper.UserMapper;
import com.newsweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public boolean delUser(int userID) { return userMapper.delUser(userID);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User findUsername(String userName,String userPassword){
        return userMapper.findUsername(userName,userPassword);
    }

    @Override
    public User findByName(String userName){
        return userMapper.findByName(userName);
    }

    @Override
    public User getUserById(int userID) {
        return userMapper.getUserById(userID);
    }

    @Override
    public User getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }


}

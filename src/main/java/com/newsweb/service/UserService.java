package com.newsweb.service;

import com.newsweb.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAll();
    public boolean addUser(User user);
    public boolean delUser(int userID);
    public boolean updateUser(User user);
    public User findUsername(String userName,String userPassword);
    public User findByName(String name);
    public User getUserById(int userID);
    public User getUserByName(String userName);
}

package com.example.demo.mapper;

import com.example.demo.entity.User;

import java.util.List;

public interface UserMapper {
    int addUser(User user);
    int deleteUser(String userId);
    int changeUserInfo(User user);
    User queryUserById(String userId);
    int changePwd(String userId, String newPwd);
    String queryPwd(String userId);
}

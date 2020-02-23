package com.example.demo.service;

import com.example.demo.entity.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface UserService {

    String login(HttpServletResponse response,String userId, String pwd, int flag) throws IOException;

    int addUser(User user);

    int deleteUser(String userId);

    int changeUserInfo(User user);

    User queryUserById(String userId);

    int changePwd(String userId, String newPwd);

    String queryPwd(String userId);
}

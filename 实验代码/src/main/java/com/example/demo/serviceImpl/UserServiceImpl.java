package com.example.demo.serviceImpl;

import com.example.demo.config.baseConfig.ResultEnum;
import com.example.demo.config.exceptionHandle.UserException;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.RedisService;
import com.example.demo.service.UserService;
import com.example.demo.util.CookieUtil;
import com.example.demo.util.MD5Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service(value = "user")
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private RedisService redisService;

    private String COOKIE_NAME_TOKEN = "token";
    private int TOKEN_MAXAGE = 60 * 60 * 2;

    @Override
    public String login(HttpServletResponse response, String userId, String pwd, int flag) throws IOException {

        //先从缓存取数据
        User user = redisService.get(userId, User.class);
        //如果缓存中没有数据，再从数据库获取数据
        if (user == null) {
            user = queryUserById(userId);
        }
        //如果没有用户数据，抛出自定义异常
        //否则刷新缓存
        if (user == null) {
            throw new UserException(ResultEnum.NOTFOUND_USER);
        } else {
            redisService.put(userId, user, 60 * 60 * 12);
        }

        //如果获取到用户数据，比较密码
        //MD5加密之后的密码
        String encryptPwd = MD5Util.md5(pwd);
        //如果密码错误，返回异常
        if (!user.getUserPwd().equals(encryptPwd)) {
            throw new UserException(ResultEnum.PASSWORD_ERROR);
        }

        String token = UUID.randomUUID().toString();
        System.out.println("当前生成token:" + token);
        //将token保存到cookie和redis
        tokenToCookieAndRedis(response, COOKIE_NAME_TOKEN, userId, TOKEN_MAXAGE);
        return token;
    }


    public void tokenToCookieAndRedis(HttpServletResponse response, String cookieName, String userId, int tokenMaxAge) throws JsonProcessingException {
        String token = UUID.randomUUID().toString();
        System.out.println("当前生成token:" + token);
        CookieUtil.setCookie(response, cookieName, token, tokenMaxAge);
        redisService.put(token, userId, tokenMaxAge);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(String userId) {
        return userMapper.deleteUser(userId);
    }

    @Override
    public int changeUserInfo(User user) {
        return userMapper.changeUserInfo(user);
    }

    @Override
    public User queryUserById(String userId) {
        return userMapper.queryUserById(userId);
    }

    @Override
    public int changePwd(String userId, String newPwd) {
        return userMapper.changePwd(userId, newPwd);
    }

    @Override
    public String queryPwd(String userId) {
        return userMapper.queryPwd(userId);
    }
}

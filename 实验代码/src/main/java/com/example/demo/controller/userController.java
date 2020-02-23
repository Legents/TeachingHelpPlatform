package com.example.demo.controller;

import com.example.demo.config.baseConfig.Result;
import com.example.demo.entity.User;
import com.example.demo.service.RedisService;
import com.example.demo.service.UserService;
import com.example.demo.util.CookieUtil;
import com.example.demo.util.ResultUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("user")
    private UserService userService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 用户登录验证
     *
     * @param userId
     * @param pwd
     * @param flag
     * @return
     */
    @ApiOperation(value = "用户登录", notes = "根据用户的类型进行登录操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户账号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pwd", value = "用户密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "flag", value = "用户类型，学生：1、教师：2、管理员：3", required = true, dataType = "int")
    })
    @PostMapping("/login")
    @ResponseBody
    public Result login(HttpServletResponse response, String userId, String pwd, int flag) throws IOException {
        System.out.println(userId + "\n" + pwd + flag);
        if (flag == 0 || flag == 1) {

            String token = userService.login(response, userId, pwd, flag);
            //如果登录成功，将生成token并将其存入cookie和redis
            HashMap<String, Object> map = new HashMap<>();
            map.put("token", token);
            if (token != null) {
                return ResultUtil.success("用户" + userId + ",登录成功", map);
            }

//            String userPwd = userService.queryPwd(userId);
//            System.out.println(userPwd);
//            if (pwd.equals(userPwd))
//                return true;
//            else
//                return false;
        } else if (flag == 2) {
            if (userId.equals("admin") && pwd.equals("admin"))
                return ResultUtil.success("管理员登录成功");
            return ResultUtil.error(-1, "管理员登陆失败！");
        }

        return ResultUtil.error(-1, "请选择用户类型");

    }

    /**
     * 管理员添加新用户
     * 输入基本用户信息后添加
     *
     * @param user
     * @return
     */

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    })
    @RequestMapping("/add")
    @ResponseBody
    public Result addUser(User user) {

        return ResultUtil.success(userService.addUser(user));
    }

    /**
     * 删除用户  根据用户id
     *
     * @param userId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Result deleteUser(String userId) {
        return ResultUtil.success(userService.deleteUser(userId));
    }

    /**
     * 修改用户基本信息
     *
     * @param user
     * @return
     */
    @RequestMapping("/change")
    public Result changeUserInfo(User user) {
        return ResultUtil.success(userService.changeUserInfo(user));
    }

    /**
     * 根据用户编号查询用户
     *
     * @param userId 需要查询的用户编号
     */
    @RequestMapping("/queryUserById")
    @ResponseBody
    public Result queryUserById(String userId) {
        Map map = new HashMap<String, Object>();
        User user = userService.queryUserById(userId);
        map.put("userList", user);
        System.out.println("/queryUserById....");
        return ResultUtil.success(map);
    }

    /**
     * 用户修改密码
     *
     * @param userId  账号
     * @param oldPwd1 旧密码
     * @param newPwd1 新密码
     * @param newPwd2 确认密码
     *                只有旧密码确认正确以及两次新密码相同时才能修改成功
     * @return
     */
    @RequestMapping("/changePwd_user")
    @ResponseBody
    public Result changePwd_user(String userId, String oldPwd1, String newPwd1, String newPwd2) {
        String result = "failed";
        String oldPwd = userService.queryPwd(userId);
        if (oldPwd.equals(oldPwd1) && newPwd1.equals(newPwd2)) {
            int res = userService.changePwd(userId, newPwd1);
            if (res != 0)
                result = "success!";
        }
        return ResultUtil.success(result);
    }
}

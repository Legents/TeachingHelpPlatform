package com.example.demo.config.interceptor;

import com.example.demo.service.RedisService;
import com.example.demo.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisService redisService;
    //前端登陆页面url
    private String loginUrl = "http://localhost:8080/user/login";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("拦截器出发了。。。" + request.getRequestURL());
        //在cookie中查找token
        String token = CookieUtil.getCookie(request, "token");
        System.out.println("token:" + token);
        CookieUtil.printCookie(request);
        //在header中找token(这个是为了使用postman调试时找到token)
        String token2 = request.getHeader("token");
        if (token2 != null) {
            token = token2;
        }

        System.out.println(request.getHeader("token"));


        //token为空，一定没登陆
        //token不为空,不一定登录
        if (token != null && !token.isEmpty()) {
            String userId = redisService.get(token);
            System.out.println(userId);
            if (userId == null || token.isEmpty()) {
                //重定向到前端的登陆页面
                response.sendRedirect(loginUrl);
                return false;
            }
        } else {
            response.sendRedirect(loginUrl);
            return false;
        }
        return true;
    }

    /**
     * 被拦截的函数执行之后才会执行该函数
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle...");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

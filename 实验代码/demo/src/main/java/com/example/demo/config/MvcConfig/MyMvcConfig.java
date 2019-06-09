package com.example.demo.config.MvcConfig;

import com.example.demo.interceptor.MyInterceptor1;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
   /* public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor1())
                .addPathPatterns("/**")//拦截的路径
                .excludePathPatterns("/","/login.html","/user/login");//排除的路径
    }*/
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");//路径映射
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("main");
        registry.addViewController("/teacherMain.html").setViewName("teacherMain");
    }
}

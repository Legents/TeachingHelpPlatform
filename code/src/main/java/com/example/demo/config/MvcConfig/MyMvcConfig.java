//package com.example.demo.config.MvcConfig;
//
//import com.example.demo.config.interceptor.LoginInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class MyMvcConfig implements WebMvcConfigurer {
//
//    //将拦截器设置为Bean,在拦截其中才能使用@AutoWired注解自动注入
//    @Bean
//    LoginInterceptor webAdminInterceptor() {
//        return new LoginInterceptor();
//    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(webAdminInterceptor())
//                .addPathPatterns("/**")
//                //"/index.html"前面必须带/
//                .excludePathPatterns("/服务员.png","/static/**","/","/user/login","/login","/index.html");
//    }
//
//    public void addViewControllers(ViewControllerRegistry registry) {
////        registry.addViewController("/").setViewName("login");//路径映射
////        registry.addViewController("/login.html").setViewName("login");
////        registry.addViewController("/main.html").setViewName("main");
////        registry.addViewController("/teacherMain.html").setViewName("teacherMain");
////        registry.addViewController("/register.html").setViewName("register");
//    }
//}

package com.newsweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginHandlerInterceptor()).
                addPathPatterns("/**").excludePathPatterns( "/","/adminlogin","/login","/regist","/user/**");
    }
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("adminlogin.html").setViewName("adminlogin");
//    }
}

package com.jovan.myconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;


//注意在在几的配置中加入的注释@Configuration
@Configuration
public class WebConfig implements  WebMvcConfigurer   {


    public HandlerInterceptor getLoginInterceptor(){
        return new MyInterceptor();
    }

    /*
    配置控制器到页面的跳转,这样就不用写在controller里面,大大减少配置
     */

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
     }


    /*
        配置拦截器的路径,
        addPathPatterns:拦截器的路径,一般配置为拦截首页
        excludePathPatterns:排除哪些不需要拦截的控制器
     */

    @Override
     public void addInterceptors(InterceptorRegistry registry){
        System.out.println("这是拦截的路径");
//        InterceptorRegistration addInterceptor = registry.addInterceptor(getLoginInterceptor());
//        addInterceptor.excludePathPatterns("/**");
//        addInterceptor.excludePathPatterns("/user/");
//        addInterceptor.excludePathPatterns("/check");
//        addInterceptor.addPathPatterns("/**");
//        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/login","/getImgCode","/GetCode");
//        super.addInterceptors(registry);
        WebMvcConfigurer.super.addInterceptors(registry);

    }








}

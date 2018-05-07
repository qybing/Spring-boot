package com.jovan.myconfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/*
这是自己的拦截器,根据自己的要求来配置自己的需求
 */


public class MyInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("进入了拦截器");
        return true;
//        System.out.println("这是自己的定制的拦截器");
//        //获取session
//        HttpSession session = request.getSession(true);
//        //判断用户ID是否存在，不存在就跳转到登录界面
//        if(session.getAttribute("userId") == null){
//            logger.info("------:跳转到login页面！");
////            response.sendRedirect("/");
////            request.getRequestDispatcher("/login.html").forward(request,response);
////            response.sendRedirect(request.getContextPath()+"/login");
//            return false;
//        }else{
//            System.out.println("已经存在的账号为:"+session.getAttribute("userId"));
//            session.setAttribute("userId", session.getAttribute("userId"));
//            return true;
//        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
    }
}

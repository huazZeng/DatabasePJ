package org.example.springboot.interceptor;

import org.example.springboot.controller.UserController;
import org.example.springboot.entity.Caterer;
import org.example.springboot.entity.User;
import org.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
public class UserInterceptor implements HandlerInterceptor {
//    @Autowired
//    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        User user = (User) request.getSession().getAttribute(UserController.SESSION_NAME);
        boolean isUser = true;
        if (request.getSession().getAttribute(UserController.SESSION_NAME) instanceof Caterer) isUser=false;
        else {
            User user = (User) request.getSession().getAttribute(UserController.SESSION_NAME);
            if (user.getType().equals("root")) isUser=false;
        }
        if(isUser) {  //没有登录
//            System.out.println("没有登录!不能访问!");
            // 重定向到登录界面
//            response.sendRedirect(request.getContextPath() + "/index.html");
            return false;
        }

        return true;    //放行
    }




}

package com.newsweb.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //管理员登录成功后,会有管理员的session
        Object admin = request.getSession().getAttribute("loginAdmin");
        Object user = request.getSession().getAttribute("user");
        if (admin == null ) {
            request.setAttribute("errMsg", "没有权限,请先登录");
            request.getRequestDispatcher("/adminlogin").forward(request, response);
            return false;
        } else {
            return true;
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

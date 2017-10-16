package com.xll.interceptor;

import com.xll.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lonely.xia on 2017/10/11.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private final Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws ServletException, IOException {

        String url = request.getRequestURI();

        LOG.info("......进入拦截器的URL:[{}]......" , url);

        if (url.equals("/") || url.contains("/resources/") || url.equals("/user/vlogin")) {

            return true;

        }

        User user =  (User)request.getSession().getAttribute("user");

        if(user == null){
            LOG.info("......请先登录!......");
            request.getSession().setAttribute("msg" , "请登录，本实例没有登录页面，请使用伪登录");
            response.sendRedirect("/index.jsp");
            return false;
        }

        return true;

    }
}

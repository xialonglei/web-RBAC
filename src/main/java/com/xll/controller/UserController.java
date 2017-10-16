package com.xll.controller;

import com.xll.annotation.SystemLog;
import com.xll.enums.PageEnum;
import com.xll.model.User;
import com.xll.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by lonely.xia on 2017/10/10.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @SystemLog(description = "伪登录")
    @RequestMapping(value = "/vlogin" , method = RequestMethod.GET)
    public String vlogin(HttpSession httpSession
            , HttpServletRequest request , HttpServletResponse response, @RequestParam Integer uid) {

        User user = userService.vlogin(uid);

        if (user != null) {
            httpSession.setAttribute("user" , user);
            request.setAttribute("page" , PageEnum.INDEX.getCode());
        } else {
            request.setAttribute("page" , PageEnum.LOGIN_HINT.getCode());
        }

        return "./../../index";
    }


}

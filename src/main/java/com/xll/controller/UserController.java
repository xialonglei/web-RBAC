package com.xll.controller;

import com.xll.annotation.SystemLog;
import com.xll.enums.PageEnum;
import com.xll.enums.ResponseEnum;
import com.xll.model.Role;
import com.xll.model.User;
import com.xll.service.UserService;
import com.xll.util.BootstrapTablePage;
import com.xll.util.GeneralResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by lonely.xia on 2017/10/10.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

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

    @SystemLog(description = "获取用户列表")
    @RequestMapping(value = "/getUserList" , method = RequestMethod.POST)
    @ResponseBody
    public BootstrapTablePage<User> getRoleList(@RequestBody BootstrapTablePage bootstrapTablePage) {
        int total = userService.countUser();
        List<User> userList = userService.getUserListByPage(bootstrapTablePage.getLimit()
                , bootstrapTablePage.getOffset());
        bootstrapTablePage.setRows(userList);
        bootstrapTablePage.setTotal(total);
        return bootstrapTablePage;
    }

    @SystemLog(description = "用户管理")
    @RequestMapping(value = "/userMgmt" , method = RequestMethod.GET)
    public String userMgmtPage(HttpServletRequest request) {
        request.setAttribute("page" , PageEnum.USER_LIST.getCode());
        return "./../../index";
    }

    @SystemLog(description = "添加用户")
    @ResponseBody
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public GeneralResponse<Integer> add(HttpServletRequest request , @RequestBody User user) {

        LOG.info("插入用户数据为[用户名：{}，用户邮箱：{}]" , user.getName() , user.getEmail());

        User result = userService.getUserByNameOrEmail(user);

        if (result != null) {
            return new GeneralResponse<>(ResponseEnum.INSERT_NAME_OR_EMAIL_DUPLICATION.getName()
                    , ResponseEnum.INSERT_NAME_OR_EMAIL_DUPLICATION.getCode());
        }

        int count = userService.insert(user);

        if (count == 0) {
            return new GeneralResponse<>(ResponseEnum.INSERT_FAIL.getName() , ResponseEnum.INSERT_FAIL.getCode());
        }

        return new GeneralResponse<>(ResponseEnum.INSERT_SUCCESS.getName() , ResponseEnum.INSERT_SUCCESS.getCode());

    }

    @ResponseBody
    @RequestMapping(value = "/getByName" , method = RequestMethod.POST)
    public GeneralResponse<Integer> getByName(HttpServletRequest request , @RequestParam String name) {

        User result = userService.getByName(name);

        if (result != null) {
            return new GeneralResponse<>(ResponseEnum.INSERT_NAME_OR_EMAIL_DUPLICATION.getName()
                    , ResponseEnum.INSERT_NAME_OR_EMAIL_DUPLICATION.getCode());
        }

        return new GeneralResponse<>(ResponseEnum.OK.getName() , ResponseEnum.OK.getCode());

    }

    @ResponseBody
    @RequestMapping(value = "/getByEmail" , method = RequestMethod.POST)
    public GeneralResponse<Integer> getByEmail(HttpServletRequest request , @RequestParam String email) {

        User result = userService.getByEmail(email);

        if (result != null) {
            return new GeneralResponse<>(ResponseEnum.INSERT_NAME_OR_EMAIL_DUPLICATION.getName()
                    , ResponseEnum.INSERT_NAME_OR_EMAIL_DUPLICATION.getCode());
        }

        return new GeneralResponse<>(ResponseEnum.OK.getName() , ResponseEnum.OK.getCode());

    }

    @ResponseBody
    @RequestMapping(value = "/getById" , method = RequestMethod.POST)
    public GeneralResponse<User> getById(HttpServletRequest request
           , @RequestParam Integer id) {

        User result = userService.getById(id);

        GeneralResponse generalResponse = new GeneralResponse();

        if (result == null) {
            generalResponse.setCode(ResponseEnum.SELECT_FAIL.getCode());
            generalResponse.setMsg(ResponseEnum.SELECT_FAIL.getName());
            return generalResponse;
        }

        generalResponse.setCode(ResponseEnum.SELECT_SUCCESS.getCode());
        generalResponse.setMsg(ResponseEnum.SELECT_SUCCESS.getName());
        generalResponse.setData(result);

        return generalResponse;

    }

    @ResponseBody
    @RequestMapping(value = "/checkUpdateName" , method = RequestMethod.POST)
    public GeneralResponse<Integer> checkUpdateName(HttpServletRequest request
            , @RequestParam Integer id , @RequestParam String name) {

        User user = userService.getByName(name);

        if (user != null && user.getId() != id) {
            return new GeneralResponse<>(ResponseEnum.UPDATE_NAME_DUPLICATION.getName()
                    , ResponseEnum.UPDATE_NAME_DUPLICATION.getCode());
        }

        return new GeneralResponse<>(ResponseEnum.OK.getName() , ResponseEnum.OK.getCode());

    }

    @ResponseBody
    @RequestMapping(value = "/checkUpdateEmail" , method = RequestMethod.POST)
    public GeneralResponse<Integer> checkUpdateEmail(HttpServletRequest request
            , @RequestParam Integer id , @RequestParam String email) {

        User user = userService.getByEmail(email);

        if (user != null && user.getId() != id) {
            return new GeneralResponse<>(ResponseEnum.UPDATE_EMAIL_DUPLICATION.getName()
                    , ResponseEnum.UPDATE_EMAIL_DUPLICATION.getCode());
        }

        return new GeneralResponse<>(ResponseEnum.OK.getName() , ResponseEnum.OK.getCode());

    }


    @SystemLog(description = "更新用户")
    @ResponseBody
    @RequestMapping(value = "/update" , method = RequestMethod.POST)
    public GeneralResponse<Integer> update(HttpServletRequest request , @RequestBody User user) {

        int count = userService.update(user);

        if (count == 0) {
            return new GeneralResponse<>(ResponseEnum.UPDATE_FAIL.getName() , ResponseEnum.UPDATE_FAIL.getCode());
        }

        return new GeneralResponse<>(ResponseEnum.UPDATE_SUCCESS.getName() , ResponseEnum.UPDATE_SUCCESS.getCode());

    }


    @SystemLog(description = "删除用户")
    @ResponseBody
    @RequestMapping(value = "/delete" , method = RequestMethod.POST)
    public GeneralResponse<Integer> delete(HttpServletRequest request , @RequestParam Integer id) {
        int count = userService.delete(id);

        if (count == 0) {
            return new GeneralResponse<>(ResponseEnum.DELETE_FAIL.getName() , ResponseEnum.DELETE_FAIL.getCode());
        }

        return new GeneralResponse<>(ResponseEnum.DELETE_SUCCESS.getName() , ResponseEnum.DELETE_SUCCESS.getCode());
    }





}

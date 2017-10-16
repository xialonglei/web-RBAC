package com.xll.service.impl;

import com.xll.mapper.UserMapper;
import com.xll.model.User;
import com.xll.model.UserExample;
import com.xll.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lonely.xia on 2017/10/10.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userDao;


    public User vlogin(int uid) {

       User user = userDao.selectByPrimaryKey(uid);

        return user;

    }
}

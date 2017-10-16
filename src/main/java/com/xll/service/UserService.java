package com.xll.service;

import com.xll.mapper.UserMapper;
import com.xll.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lonely.xia on 2017/10/10.
 */
public interface UserService {


    User vlogin(int uid);

}

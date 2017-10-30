package com.xll.service;

import com.xll.model.User;
import java.util.List;

/**
 * Created by lonely.xia on 2017/10/10.
 */
public interface UserService {


    User vlogin(int uid);

    int countUser();

    List<User> getUserListByPage(int limit , int offset);

    User getUserByNameOrEmail(User user);

    Integer insert(User user);

    User getByName(String name);

    User getByEmail(String email);

    User getById(Integer id);

    int update(User user);

    int delete(Integer id);

}

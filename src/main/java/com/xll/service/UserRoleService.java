package com.xll.service;

import com.xll.model.UserRole;

/**
 * Created by lonely.xia on 2017/10/29.
 */
public interface UserRoleService {
    int insert(Integer userId, Integer roleId);

    int deleteByUserId(Integer id);

    UserRole getByUserId(Integer uid);

    int update(UserRole userRole);
}

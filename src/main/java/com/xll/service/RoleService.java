package com.xll.service;

import com.xll.model.Role;

import java.util.List;

/**
 * Created by lonely.xia on 2017/10/12.
 */
public interface RoleService {

    List<Role> getRoleListByPage(int limit , int offset);

    int countRole();
}

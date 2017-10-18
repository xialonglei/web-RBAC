package com.xll.service;

import com.xll.model.Role;

import java.util.List;

/**
 * Created by lonely.xia on 2017/10/12.
 */
public interface RoleService {

    List<Role> getRoleListByPage(int limit , int offset);

    int countRole();

    int insert(Role role);

    /** 通过角色名来查找角色记录，角色也是唯一的 */
    Role getRoleByName(Role role);

    Role getRoleById(Role role);

    int update(Role role);

    int delete(Role role);

    Role getRoleByNameAndStatus(Role role);
}

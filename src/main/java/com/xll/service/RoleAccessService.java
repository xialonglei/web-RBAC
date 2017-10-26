package com.xll.service;

import com.xll.model.RoleAccess;

import java.util.List;

/**
 * Created by lonely.xia on 2017/10/26.
 */
public interface RoleAccessService {
    List<RoleAccess> getRoleAccessListByRoleId(Integer roleId);

    int insert(RoleAccess roleAccess);

    int delete(Integer id);
}

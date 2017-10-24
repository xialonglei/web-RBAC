package com.xll.service;

import com.xll.model.Access;

import java.util.List;

/**
 * Created by lonely.xia on 2017/10/24.
 */
public interface AccessService {

    int countRole();

    List<Access> getRoleListByPage(int limit, int offset);
}

package com.xll.service;

import com.xll.model.Access;

import java.util.List;

/**
 * Created by lonely.xia on 2017/10/24.
 */
public interface AccessService {

    int countRole();

    List<Access> getAccessListByPage(int limit, int offset);

    Access getAccessByTitle(Access access);

    int insert(Access access);

    int delete(Access access);

    Access getAccessById(Access access);

    int update(Access access);
}

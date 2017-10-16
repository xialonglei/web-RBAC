package com.xll.service.impl;

import com.xll.mapper.RoleMapper;
import com.xll.model.Role;
import com.xll.model.RoleExample;
import com.xll.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Created by lonely.xia on 2017/10/12.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleDao;

    @Override
    public List<Role> getRoleListByPage(int limit , int offset) {

        RoleExample roleExample = new RoleExample();

        roleExample.setPageSize(limit);
        roleExample.setOffset(offset);

        List<Role> roleList = roleDao.selectByExample(roleExample);

        if (roleList == null) {
            roleList = Collections.EMPTY_LIST;
        }

        return roleList;
    }

    @Override
    public int countRole() {
        return roleDao.countByExample(new RoleExample());
    }
}

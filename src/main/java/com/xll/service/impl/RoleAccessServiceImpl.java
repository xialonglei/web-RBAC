package com.xll.service.impl;

import com.xll.mapper.RoleAccessMapper;
import com.xll.model.RoleAccess;
import com.xll.model.RoleAccessExample;
import com.xll.service.RoleAccessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lonely.xia on 2017/10/26.
 */
@Service("roleAccessService")
public class RoleAccessServiceImpl implements RoleAccessService{

    @Resource
    private RoleAccessMapper roleAccessDao;

    @Override
    public List<RoleAccess> getRoleAccessListByRoleId(Integer roleId) {

        RoleAccessExample roleAccessExample = new RoleAccessExample();
        RoleAccessExample.Criteria criteria = roleAccessExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);

        List<RoleAccess> roleAccessList = roleAccessDao.selectByExample(roleAccessExample);

        if (roleAccessList == null || roleAccessList.size() == 0) {
            return Collections.emptyList();
        }

        return roleAccessList;

    }

    @Override
    public int insert(RoleAccess roleAccess) {
        return roleAccessDao.insertSelective(roleAccess);
    }

    @Override
    public int delete(Integer id) {
        return roleAccessDao.deleteByPrimaryKey(id);
    }
}

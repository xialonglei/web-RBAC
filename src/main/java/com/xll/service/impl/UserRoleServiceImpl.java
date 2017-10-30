package com.xll.service.impl;

import com.xll.mapper.UserRoleMapper;
import com.xll.model.UserRole;
import com.xll.model.UserRoleExample;
import com.xll.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lonely.xia on 2017/10/29.
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleDao;
    @Override
    public int insert(Integer userId, Integer roleId) {
        UserRole userRole = new UserRole();
        userRole.setUid(userId);
        userRole.setRoleId(roleId);
        return userRoleDao.insert(userRole);
    }

    @Override
    public int deleteByUserId(Integer uid) {
        return userRoleDao.deleteByUserId(uid);
    }

    @Override
    public UserRole getByUserId(Integer uid) {

        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andUidEqualTo(uid);

        List<UserRole> userRoleList = userRoleDao.selectByExample(userRoleExample);

        if (userRoleList == null || userRoleList.size() == 0) {
            return null;
        }

        return userRoleList.get(0);
    }

    @Override
    public int update(UserRole userRole) {
        return userRoleDao.updateByPrimaryKeySelective(userRole);
    }
}

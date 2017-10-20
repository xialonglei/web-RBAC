package com.xll.service.impl;

import com.xll.mapper.UserMapper;
import com.xll.model.RoleExample;
import com.xll.model.User;
import com.xll.model.UserExample;
import com.xll.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Created by lonely.xia on 2017/10/10.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userDao;


    public User vlogin(int uid) {

       User user = userDao.selectByPrimaryKey(uid);

        return user;

    }

    @Override
    public int countUser() {
        return userDao.countByExample(new UserExample());
    }

    @Override
    public List<User> getUserListByPage(int limit, int offset) {

        UserExample userExample = new UserExample();

        userExample.setPageSize(limit);
        userExample.setOffset(offset);

        List<User> userList = userDao.selectByExample(userExample);

        if (userList == null) {
            userList = Collections.EMPTY_LIST;
        }

        return userList;
    }

    @Override
    public User getUserByNameOrEmail(User user) {

        UserExample userExample = new UserExample();
        UserExample.Criteria nameCriteria = userExample.createCriteria();
        nameCriteria.andNameEqualTo(user.getName());

        UserExample.Criteria emailCriteria = userExample.createCriteria();
        emailCriteria.andEmailEqualTo(user.getEmail());

        userExample.or(emailCriteria);

        List<User> userList = userDao.selectByExample(userExample);

        if (userList == null || userList.size() == 0) {
            return null;
        }

        return userList.get(0);

    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public User getByName(String name) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo(name);

        List<User> userList = userDao.selectByExample(userExample);

        if (userList == null || userList.size() == 0) {
            return null;
        }

        return userList.get(0);
    }

    @Override
    public User getByEmail(String email) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(email);

        List<User> userList = userDao.selectByExample(userExample);

        if (userList == null || userList.size() == 0) {
            return null;
        }

        return userList.get(0);
    }

    @Override
    public User getById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public int update(User user) {
        return userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.deleteByPrimaryKey(id);
    }
}

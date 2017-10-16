package com.xll.mapper;

import com.xll.model.User;
import com.xll.model.UserExample;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("userDao")
public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
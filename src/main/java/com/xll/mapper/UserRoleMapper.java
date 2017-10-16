package com.xll.mapper;

import com.xll.model.UserRole;
import com.xll.model.UserRoleExample;
import java.util.List;

public interface UserRoleMapper {
    int countByExample(UserRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExample(UserRoleExample example);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}
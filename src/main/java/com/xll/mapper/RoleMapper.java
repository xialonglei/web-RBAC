package com.xll.mapper;

import com.xll.model.Role;
import com.xll.model.RoleExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}
package com.xll.mapper;

import com.xll.model.RoleAccess;
import com.xll.model.RoleAccessExample;
import java.util.List;

public interface RoleAccessMapper {
    int countByExample(RoleAccessExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleAccess record);

    int insertSelective(RoleAccess record);

    List<RoleAccess> selectByExample(RoleAccessExample example);

    RoleAccess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleAccess record);

    int updateByPrimaryKey(RoleAccess record);
}
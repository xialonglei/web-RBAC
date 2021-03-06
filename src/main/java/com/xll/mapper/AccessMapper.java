package com.xll.mapper;

import com.xll.model.Access;
import com.xll.model.AccessExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accessDao")
public interface AccessMapper {
    int countByExample(AccessExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Access record);

    int insertSelective(Access record);

    List<Access> selectByExample(AccessExample example);

    Access selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Access record);

    int updateByPrimaryKey(Access record);
}
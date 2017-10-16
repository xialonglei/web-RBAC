package com.xll.mapper;

import com.xll.model.OperateLogInfo;
import com.xll.model.OperateLogInfoExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("operateLogInfoDao")
public interface OperateLogInfoMapper {
    int countByExample(OperateLogInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperateLogInfo record);

    int insertSelective(OperateLogInfo record);

    List<OperateLogInfo> selectByExample(OperateLogInfoExample example);

    OperateLogInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperateLogInfo record);

    int updateByPrimaryKey(OperateLogInfo record);
}
package com.xll.service.impl;

import com.xll.mapper.OperateLogInfoMapper;
import com.xll.model.OperateLogInfo;
import com.xll.service.OperateLogInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lonely.xia on 2017/10/16.
 */

@Service("operateLogInfoService")
public class OperateLogInfoServiceImpl implements OperateLogInfoService {

    @Resource
    private OperateLogInfoMapper operateLogInfoDao;

    @Override
    public int update(OperateLogInfo operateLogInfo) {
        return operateLogInfoDao.updateByPrimaryKeySelective(operateLogInfo);
    }

    @Override
    public int insert(OperateLogInfo operateLogInfo) {
        int count = operateLogInfoDao.insertSelective(operateLogInfo);
        return count;
    }
}

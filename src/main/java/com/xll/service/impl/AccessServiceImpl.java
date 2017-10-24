package com.xll.service.impl;

import com.xll.mapper.AccessMapper;
import com.xll.model.Access;
import com.xll.model.AccessExample;
import com.xll.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Created by lonely.xia on 2017/10/24.
 */
@Service("accessService")
public class AccessServiceImpl implements AccessService {


    @Resource
    private AccessMapper accessDao;

    @Override
    public int countRole() {

        return accessDao.countByExample(new AccessExample());
    }

    @Override
    public List<Access> getRoleListByPage(int limit, int offset) {
        AccessExample accessExample = new AccessExample();

        accessExample.setPageSize(limit);
        accessExample.setOffset(offset);

        List<Access> accessList = accessDao.selectByExample(accessExample);

        if (accessList == null) {
            accessList = Collections.EMPTY_LIST;
        }

        return accessList;
    }
}

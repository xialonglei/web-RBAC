package com.xll.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xll.mapper.AccessMapper;
import com.xll.model.Access;
import com.xll.model.AccessExample;
import com.xll.service.AccessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by lonely.xia on 2017/10/24.
 */
@Service("accessService")
public class AccessServiceImpl implements AccessService {


    @Resource
    private AccessMapper accessDao;

    @Override
    public int countAccess() {

        return accessDao.countByExample(new AccessExample());
    }

    @Override
    public List<Access> getAccessListByPage(int limit, int offset) {

        AccessExample accessExample = new AccessExample();

        accessExample.setPageSize(limit);
        accessExample.setOffset(offset);

        List<Access> accessList = accessDao.selectByExample(accessExample);

        if (accessList == null) {
            return Collections.EMPTY_LIST;
        }

        for (Access access : accessList) {
            convertToString(access , "<br/>");
        }

        return accessList;
    }

    private void convertToString (Access access , String separator) {

        JSONArray uris = JSON.parseArray(access.getUris());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < uris.size(); i++) {

            JSONObject jsonObject = (JSONObject) uris.get(i);

            if (i == uris.size() - 1) {
                sb.append(jsonObject.getString("uri"));
            } else {
                sb.append(jsonObject.getString("uri") + separator);
            }
        }

        access.setUris(sb.toString());
    }

    @Override
    public Access getAccessByTitle(Access access) {

        AccessExample accessExample = new AccessExample();
        AccessExample.Criteria criteria = accessExample.createCriteria();
        criteria.andTitleEqualTo(access.getTitle());

        List<Access> accessList = accessDao.selectByExample(accessExample);

        if (accessList == null || accessList.size() == 0) {
            return null;
        }

        return accessList.get(0);
    }

    @Override
    public int insert(Access access) {

        convertToJson(access);

        return accessDao.insertSelective(access);

    }

    private void convertToJson(Access access) {
        String[] uriArray = access.getUris().split("\n");

        List<Map<String , String>> uriList = new ArrayList<Map<String , String>>();

        for (String uri : uriArray) {

            Map<String , String> map = new HashMap<>();
            map.put("uri" , uri);
            uriList.add(map);

        }

        String uris = JSON.toJSONString(uriList);

        access.setUris(uris);
    }

    @Override
    public int delete(Access access) {
        return accessDao.deleteByPrimaryKey(access.getId());
    }

    @Override
    public Access getAccessById(Access access) {

        Access result = accessDao.selectByPrimaryKey(access.getId());

        convertToString(result , "\n");

        return result;
    }

    @Override
    public int update(Access access) {
        convertToJson(access);
        return accessDao.updateByPrimaryKeySelective(access);
    }

    @Override
    public List<Access> getAllAccess() {
        return accessDao.selectByExample(new AccessExample());
    }
}
package com.xll.controller;

import com.xll.annotation.SystemLog;
import com.xll.enums.ResponseEnum;
import com.xll.model.Role;
import com.xll.model.RoleAccess;
import com.xll.service.RoleAccessService;
import com.xll.util.GeneralResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lonely.xia on 2017/10/26.
 */
@Controller
@RequestMapping("role_access")
public class RoleAccessController {

    private static final Logger LOG = LoggerFactory.getLogger(RoleAccessController.class);

    @Resource
    private RoleAccessService roleAccessService;

    @RequestMapping("getAccessIdsByRoleId")
    @ResponseBody
    public  GeneralResponse<List<Integer>> getAccessIdsByRoleId(HttpSession session , @RequestParam Integer roleId) {

        List<RoleAccess> roleAccessList = roleAccessService.getRoleAccessListByRoleId(roleId);

        List<Integer> ids = new ArrayList<>();

        for (RoleAccess roleAccess : roleAccessList) {
            ids.add(roleAccess.getAccessId());
        }

        if (ids.size() == 0) {
            return new GeneralResponse<>(ResponseEnum.SELECT_FAIL.getName() , ResponseEnum.SELECT_FAIL.getCode());
        }

        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMsg(ResponseEnum.SELECT_SUCCESS.getName());
        generalResponse.setCode(ResponseEnum.SELECT_SUCCESS.getCode());
        generalResponse.setData(ids);

        return generalResponse;


    }

    @SystemLog(description = "设置权限")
    @RequestMapping("setAccess")
    @ResponseBody
    public  GeneralResponse<List<Integer>> setAccess(HttpSession session , @RequestParam Integer roleId
            , @RequestParam("accessIds[]") Integer[] accessArray) {

        List<Integer> accessIds = Arrays.asList(accessArray);

        List<RoleAccess> roleAccessList = roleAccessService.getRoleAccessListByRoleId(roleId);

        List<Integer> ids = new ArrayList<>();

        for (RoleAccess roleAccess : roleAccessList) {
            ids.add(roleAccess.getAccessId());
        }

        for (Integer accessId : accessIds) {
            if (ids.contains(accessId)) {
                continue;
            }
            RoleAccess roleAccess = new RoleAccess();
            roleAccess.setAccessId(accessId);
            roleAccess.setRoleId(roleId);

            int count = roleAccessService.insert(roleAccess);

            if (count == 0) {
                LOG.error("设置权限[roleId:{},accessId:{}]失败" , roleId , accessId);
            }
        }


        for (RoleAccess roleAccess : roleAccessList) {
            if (accessIds.contains(roleAccess.getAccessId())) {
                continue;
            }

            int count = roleAccessService.delete(roleAccess.getId());

            if (count == 0) {
                LOG.error("设置权限[id:{}]失败" , roleAccess.getId());
            }
        }


        return new GeneralResponse<>(ResponseEnum.OK.getName() , ResponseEnum.OK.getCode());

    }
}

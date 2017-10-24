package com.xll.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xll.annotation.SystemLog;
import com.xll.enums.PageEnum;
import com.xll.enums.ResponseEnum;
import com.xll.model.Access;
import com.xll.service.AccessService;
import com.xll.util.BootstrapTablePage;
import com.xll.util.GeneralResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lonely.xia on 2017/10/23.
 */
@Controller
@RequestMapping("/access")
public class AccessController {

    private static final Logger LOG = LoggerFactory.getLogger(AccessController.class);

    @Resource
    private AccessService accessService;

    @RequestMapping(value = "/getAccessList" , method = RequestMethod.POST)
    @ResponseBody
    public BootstrapTablePage<Access> getRoleList(@RequestBody BootstrapTablePage bootstrapTablePage) {
        int total = accessService.countRole();
        List<Access> accessList = accessService.getAccessListByPage(bootstrapTablePage.getLimit()
                , bootstrapTablePage.getOffset());
        bootstrapTablePage.setRows(accessList);
        bootstrapTablePage.setTotal(total);
        return bootstrapTablePage;
    }

    @SystemLog(description = "权限管理")
    @RequestMapping(value = "/accessMgmt" , method = RequestMethod.GET)
    public String roleMgmtPage(HttpServletRequest request) {
        request.setAttribute("page" , PageEnum.ACCESS_LIST.getCode());
        return "./../../index";
    }


    @SystemLog(description = "添加权限")
    @ResponseBody
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public GeneralResponse<Integer> add(HttpServletRequest request , @RequestBody Access access) {

        Access result = accessService.getAccessByTitle(access);

        if (result != null) {
            return new GeneralResponse<>(ResponseEnum.INSERT_OR_UPDATE_TITLE_DUPLICATION.getName()
                    , ResponseEnum.INSERT_OR_UPDATE_TITLE_DUPLICATION.getCode());
        }

        int count = accessService.insert(access);

        if (count == 0) {
            return new GeneralResponse<>(ResponseEnum.INSERT_FAIL.getName() , ResponseEnum.INSERT_FAIL.getCode());
        }

        return new GeneralResponse<>(ResponseEnum.INSERT_SUCCESS.getName() , ResponseEnum.INSERT_SUCCESS.getCode());

    }


    @SystemLog(description = "删除权限")
    @ResponseBody
    @RequestMapping(value = "/delete" , method = RequestMethod.POST)
    public GeneralResponse<Integer> delete(@RequestBody Access access) {
        int count = accessService.delete(access);

        if (count == 0) {
            return new GeneralResponse<>(ResponseEnum.DELETE_FAIL.getName() , ResponseEnum.DELETE_FAIL.getCode());
        }

        return new GeneralResponse<>(ResponseEnum.DELETE_SUCCESS.getName() , ResponseEnum.DELETE_SUCCESS.getCode());
    }

    @SystemLog(description = "根据ID获取权限")
    @ResponseBody
    @RequestMapping(value = "/getById" , method = RequestMethod.POST)
    public GeneralResponse<Access> getById(HttpServletRequest request , @RequestBody Access access) {

        Access result = accessService.getAccessById(access);

        GeneralResponse generalResponse = new GeneralResponse();

        if (result == null) {
            generalResponse.setCode(ResponseEnum.SELECT_FAIL.getCode());
            generalResponse.setMsg(ResponseEnum.SELECT_FAIL.getName());
            return generalResponse;
        }

        generalResponse.setCode(ResponseEnum.SELECT_SUCCESS.getCode());
        generalResponse.setMsg(ResponseEnum.SELECT_SUCCESS.getName());
        generalResponse.setData(result);

        return generalResponse;

    }


    @SystemLog(description = "更新权限")
    @ResponseBody
    @RequestMapping(value = "/update" , method = RequestMethod.POST)
    public GeneralResponse<Integer> update(HttpServletRequest request , @RequestBody Access access) {

        Access result = accessService.getAccessByTitle(access);

        if (result != null && result.getId() != access.getId()) {
            return new GeneralResponse<>(ResponseEnum.INSERT_OR_UPDATE_TITLE_DUPLICATION.getName()
                    , ResponseEnum.INSERT_OR_UPDATE_TITLE_DUPLICATION.getCode());
        }

        int count = accessService.update(access);

        if (count == 0) {
            return new GeneralResponse<>(ResponseEnum.UPDATE_FAIL.getName() , ResponseEnum.UPDATE_FAIL.getCode());
        }

        return new GeneralResponse<>(ResponseEnum.UPDATE_SUCCESS.getName() , ResponseEnum.UPDATE_SUCCESS.getCode());

    }


}

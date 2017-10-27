package com.xll.controller;

import com.xll.annotation.SystemLog;
import com.xll.enums.PageEnum;
import com.xll.enums.ResponseEnum;
import com.xll.model.Role;
import com.xll.service.RoleService;
import com.xll.util.BootstrapTablePage;
import com.xll.util.GeneralResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lonely.xia on 2017/10/12.
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @SystemLog(description = "获取角色列表")
    @RequestMapping(value = "/getRoleList" , method = RequestMethod.POST)
    @ResponseBody
    public BootstrapTablePage<Role> getRoleList(@RequestBody BootstrapTablePage bootstrapTablePage) {
        int total = roleService.countRole();
        List<Role> roleList = roleService.getRoleListByPage(bootstrapTablePage.getLimit()
                , bootstrapTablePage.getOffset());
        bootstrapTablePage.setRows(roleList);
        bootstrapTablePage.setTotal(total);
        return bootstrapTablePage;
    }

    @SystemLog(description = "角色管理")
    @RequestMapping(value = "/roleMgmt" , method = RequestMethod.GET)
    public String roleMgmtPage(HttpServletRequest request) {
        request.setAttribute("page" , PageEnum.ROLE_LIST.getCode());
        return "./../../index";
    }

    @SystemLog(description = "添加角色")
    @ResponseBody
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public GeneralResponse<Integer> add(HttpServletRequest request , @RequestBody Role role) {

        Role result = roleService.getRoleByName(role);

        if (result != null) {
            return new GeneralResponse<>(ResponseEnum.INSERT_OR_UPDATE_ROLE_NAME_DUPLICATION.getName()
                    , ResponseEnum.INSERT_OR_UPDATE_ROLE_NAME_DUPLICATION.getCode());
        }

        int count = roleService.insert(role);

        if (count == 0) {
            return new GeneralResponse<>(ResponseEnum.INSERT_FAIL.getName() , ResponseEnum.INSERT_FAIL.getCode());
        }

        return new GeneralResponse<>(ResponseEnum.INSERT_SUCCESS.getName() , ResponseEnum.INSERT_SUCCESS.getCode());

    }


    @SystemLog(description = "更新角色")
    @ResponseBody
    @RequestMapping(value = "/update" , method = RequestMethod.POST)
    public GeneralResponse<Integer> update(HttpServletRequest request , @RequestBody Role role) {
        Role result = roleService.getRoleByNameAndStatus(role);

        if (result != null) {
            return new GeneralResponse<>(ResponseEnum.INSERT_OR_UPDATE_ROLE_NAME_DUPLICATION.getName()
                    , ResponseEnum.INSERT_OR_UPDATE_ROLE_NAME_DUPLICATION.getCode());
        }

        int count = roleService.update(role);

        if (count == 0) {
            return new GeneralResponse<>(ResponseEnum.UPDATE_FAIL.getName() , ResponseEnum.UPDATE_FAIL.getCode());
        }

        return new GeneralResponse<>(ResponseEnum.UPDATE_SUCCESS.getName() , ResponseEnum.UPDATE_SUCCESS.getCode());

    }

    @SystemLog(description = "根据ID获取角色")
    @ResponseBody
    @RequestMapping(value = "/getById" , method = RequestMethod.POST)
    public GeneralResponse<Role> getById(HttpServletRequest request , @RequestBody Role role) {

        Role result = roleService.getRoleById(role);

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

    @SystemLog(description = "删除角色")
    @ResponseBody
    @RequestMapping(value = "/delete" , method = RequestMethod.POST)
    public GeneralResponse<Integer> delete(@RequestBody Role role) {
        int count = roleService.delete(role);

        if (count == 0) {
            return new GeneralResponse<>(ResponseEnum.DELETE_FAIL.getName() , ResponseEnum.DELETE_FAIL.getCode());
        }

        return new GeneralResponse<>(ResponseEnum.DELETE_SUCCESS.getName() , ResponseEnum.DELETE_SUCCESS.getCode());
    }


    @RequestMapping(value = "/getAll" , method = RequestMethod.GET)
    @ResponseBody
    public GeneralResponse<List<Role>> getAll(HttpServletRequest request) {

        List<Role> roleList = roleService.getAll();

        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMsg(ResponseEnum.SELECT_SUCCESS.getName());
        generalResponse.setCode(ResponseEnum.SELECT_SUCCESS.getCode());
        generalResponse.setData(roleList);

        return generalResponse;
    }


}

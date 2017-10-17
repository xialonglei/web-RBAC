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

        Role roleForName = roleService.getRoleByName(role);

        if (roleForName != null) {
            return new GeneralResponse<>(ResponseEnum.INSERT_ROLE_NAME_DUPLICATION.getName()
                    , ResponseEnum.INSERT_ROLE_NAME_DUPLICATION.getCode());
        }

        int count = roleService.insert(role);

        if (count == 0) {
            return new GeneralResponse<>(ResponseEnum.INSERT_FAIL.getName() , ResponseEnum.INSERT_FAIL.getCode());
        }

        return new GeneralResponse<>(ResponseEnum.INSERT_SUCCESS.getName() , ResponseEnum.INSERT_SUCCESS.getCode());

    }
}

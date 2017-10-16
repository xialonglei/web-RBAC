package com.xll.controller;

import com.xll.enums.PageEnum;
import com.xll.model.Role;
import com.xll.service.RoleService;
import com.xll.util.BootstrapTablePage;
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

    @RequestMapping(value = "/roleMgmt" , method = RequestMethod.GET)
    public String roleMgmtPage(HttpServletRequest request) {
        request.setAttribute("page" , PageEnum.ROLE_LIST.getCode());
        return "./../../index";
    }


}

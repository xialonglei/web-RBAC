package com.xll.controller;

import com.xll.annotation.SystemLog;
import com.xll.enums.PageEnum;
import com.xll.model.Access;
import com.xll.service.AccessService;
import com.xll.util.BootstrapTablePage;
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

    @Resource
    private AccessService accessService;



    @RequestMapping(value = "/getAccessList" , method = RequestMethod.POST)
    @ResponseBody
    public BootstrapTablePage<Access> getRoleList(@RequestBody BootstrapTablePage bootstrapTablePage) {
        int total = accessService.countRole();
        List<Access> accessList = accessService.getRoleListByPage(bootstrapTablePage.getLimit()
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
}

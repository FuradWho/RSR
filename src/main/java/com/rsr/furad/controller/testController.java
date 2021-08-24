package com.rsr.furad.controller;

import com.rsr.furad.pojo.SysRole;
import com.rsr.furad.pojo.UserInfo;
import com.rsr.furad.service.SysPermissionService;
import com.rsr.furad.service.SysRoleService;
import com.rsr.furad.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class testController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @GetMapping(value = "/test")
    public List test(){
        return sysPermissionService.findPermissionByRoleId(1);
    }

}

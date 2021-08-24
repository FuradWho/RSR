package com.rsr.furad.service.Impl;

import com.rsr.furad.mapper.SysPermissionMapper;
import com.rsr.furad.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("SysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<Map> findPermissionByRoleId(Integer roleId) {
        return sysPermissionMapper.findPermissionByRoleId(roleId);
    }
}

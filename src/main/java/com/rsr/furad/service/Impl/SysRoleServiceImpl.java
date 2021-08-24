package com.rsr.furad.service.Impl;

import com.rsr.furad.mapper.SysRoleMapper;
import com.rsr.furad.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SysRoleService")
public class SysRoleServiceImpl implements SysRoleService {


    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List findRoleByUsername(String username) {
        return sysRoleMapper.findRoleByUsername(username);
    }
}

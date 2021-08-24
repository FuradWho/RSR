package com.rsr.furad.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysPermissionService {

    List<Map> findPermissionByRoleId(Integer roleId);
}

package com.rsr.furad.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 13375
 */
public interface SysRoleService {

    List<Map> findRoleByUsername(String username);
}

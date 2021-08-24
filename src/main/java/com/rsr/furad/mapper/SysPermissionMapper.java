package com.rsr.furad.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rsr.furad.pojo.SysPermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 13375
 */
@Repository
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    //根据角色ID查询角色对应的权限信息

    @Select("SELECT sys_role.id, sys_role.available, sys_role.description, sys_role.role, sys_permission.`name`, sys_permission.permission, sys_permission.url FROM (sys_permission, sys_role) RIGHT JOIN sys_role_permission ON sys_permission.id = sys_role_permission.permission_id AND sys_role_permission.role_id = sys_role.id WHERE sys_role.id=#{roleId} ")
    List<Map> findPermissionByRoleId(@Param("roleId") Integer roleId);
}

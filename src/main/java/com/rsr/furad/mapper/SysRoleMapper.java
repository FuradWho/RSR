package com.rsr.furad.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rsr.furad.pojo.SysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 13375
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    //通过username查找用户角色信息

    @Select("Select user_info.uid, user_info.`name`, user_info.`password`, user_info.salt, user_info.state, user_info.username, sys_role.id, sys_role.available, sys_role.description, sys_role.role FROM user_info RIGHT JOIN sys_user_role ON user_info.uid = sys_user_role.uid LEFT JOIN sys_role ON sys_user_role.role_id = sys_role.id WHERE username=#{username}")
    List<Map> findRoleByUsername(@Param("username") String username);
}

package com.rsr.furad.realm;

import com.rsr.furad.config.MySimpleByteSource;
import com.rsr.furad.mapper.SysPermissionMapper;
import com.rsr.furad.mapper.SysRoleMapper;
import com.rsr.furad.pojo.UserInfo;
import com.rsr.furad.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author 13375
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    private SimpleAuthenticationInfo info = null;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("权限配置-->ShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();

        sysRoleMapper.findRoleByUsername(userInfo.getUsername()).stream().forEach(
                sysRole -> {
                    authorizationInfo.addRole(sysRole.get("role").toString());
                    sysPermissionMapper.findPermissionByRoleId((Integer) sysRole.get("id")).stream().forEach(
                            sysPermission -> {
                                authorizationInfo.addStringPermission(sysPermission.get("permission").toString());
                            }
                    );
                }
        );
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("认证配置-->MyShiroRealm.doGetAuthenticationInfo()");

        // 将token装换成UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;

        String name = upToken.getUsername();

        System.out.println(name);
        UserInfo userInfo = userInfoService.findByName(name);

        if (userInfo != null) {
            // 如果查询到了，封装查询结果，返回给我们的调用
            Object principal =  userInfo.getName();
            Object credentials = userInfo.getPassword();

            // 获取盐值，即用户名
            ByteSource salt = new MySimpleByteSource(userInfo.getSalt());
            String realmName = this.getName();

            SecurityUtils.getSubject().getSession().setAttribute("currentLoginedUser", userInfo);

            info = new SimpleAuthenticationInfo(principal,credentials,salt,realmName);
        }else {
            // 如果没有查询到，抛出一个异常
            throw new AuthenticationException();
        }

        return info;
    }
}

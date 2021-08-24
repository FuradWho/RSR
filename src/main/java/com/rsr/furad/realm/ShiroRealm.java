package com.rsr.furad.realm;

import com.rsr.furad.mapper.SysPermissionMapper;
import com.rsr.furad.mapper.SysRoleMapper;
import com.rsr.furad.pojo.UserInfo;
import com.rsr.furad.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
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

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("权限配置-->ShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo  = (UserInfo)principalCollection.getPrimaryPrincipal();

        sysRoleMapper.findRoleByUsername(userInfo.getUsername()).stream().forEach(
                sysRole ->{
                    authorizationInfo.addRole(sysRole.get("role").toString());
                    sysPermissionMapper.findPermissionByRoleId((Integer)sysRole.get("id")).stream().forEach(
                          sysPermission ->{
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

        String username = (String) authenticationToken.getPrincipal();
        UserInfo userInfo = userInfoService.findByUsername(username);

        if(userInfo == null){
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo( userInfo,userInfo.getPassword(), ByteSource.Util.bytes(userInfo.getCredentialsSalt()),getName() );

        return authenticationInfo;
    }
}

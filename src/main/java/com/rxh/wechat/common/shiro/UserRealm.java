package com.rxh.wechat.common.shiro;

import com.rxh.wechat.common.shiro.entity.SysPermission;
import com.rxh.wechat.common.shiro.entity.SysRole;
import com.rxh.wechat.common.shiro.entity.SysUser;
import com.rxh.wechat.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @Description: 自定义Realm，实现授权与认证
 * @Author Zhang YuHui 
 * @Date 2020/11/6 10:48
 *
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService userService;
    /**
     * @description: 授权 权限的分发
     * @author: zyh
     * @date: 2020/11/6
     * @param null
     * @return:
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        if(sysUser != null){
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            Collection<String> sysRoleCollection = new HashSet<>();
            Collection<String> sysPermissionCollection = new HashSet<>();

            Set<SysRole> sysRoles = sysUser.getSysRoles();
            for(SysRole role : sysRoles){
                Set<SysPermission> sysPermissions = role.getSysPermissions();
                sysRoleCollection.add(role.getRoleName());
                for (SysPermission sysPermission : sysPermissions){
                    sysPermissionCollection.add(sysPermission.getPermissionCode());
                }
                authorizationInfo.addStringPermissions(sysPermissionCollection);
            }
            authorizationInfo.addRoles(sysRoleCollection);
            return authorizationInfo;
        }
        return null;
    }

    /**
     * @description: 用户认证
     * @author: zyh
     * @date: 2020/11/6
     * @param null
     * @return:
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        SysUser sysUser = userService.queryByName(username);
        if(sysUser == null){
            throw new UnknownAccountException();
        }

        ByteSource bytes = ByteSource.Util.bytes(sysUser.getUsername());
        return new SimpleAuthenticationInfo(sysUser,sysUser.getPassword(),bytes,sysUser.getUsername());

    }


}

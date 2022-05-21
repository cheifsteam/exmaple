package com.example.spring_security.config;

import com.example.spring_security.domain.SysPermission;
import com.example.spring_security.domain.SysRole;
import com.example.spring_security.domain.UserInfo;
import com.example.spring_security.sevice.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.crazycake.shiro.RedisCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.management.relation.Role;
import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MyRealm extends AuthorizingRealm {
    @Resource
    private UserInfoService userInfoService;

    private RedisCacheManager redisCacheManager;



    @Autowired(required = false)
    public void setRedisCacheManager(RedisCacheManager redisCacheManager) {
        this.redisCacheManager = redisCacheManager;
    }
    @PostConstruct
    private void initConfig() {
        setAuthenticationCachingEnabled(false);
        setAuthorizationCachingEnabled(true);
        setCachingEnabled(true);
        setCacheManager(redisCacheManager);
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权开始");
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
        for (SysRole sysRole : userInfo.getRoleList()) {
            simpleAuthorizationInfo.addRole(sysRole.getRole());
            for (SysPermission sysPermission : sysRole.getPermissions()) {
                simpleAuthorizationInfo.addStringPermission(sysPermission.getPermission());
            }
        }
        return  simpleAuthorizationInfo;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("开始认证");
        String useName=(String)token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        UserInfo userInfo = userInfoService.findByUsername(useName);
        if (userInfo==null||!StringUtils.equals(password, userInfo.getPassword()))
        {
            throw new IncorrectCredentialsException("用户名错误或者密码错误");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
}

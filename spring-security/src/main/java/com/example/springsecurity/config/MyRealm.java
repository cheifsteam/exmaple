//package com.example.springsecurity.config;
//import com.example.springsecurity.domain.Role;
//import com.example.springsecurity.domain.User;
//import com.example.springsecurity.domain.UserDataPermissionKey;
//import com.example.springsecurity.service.UserDataPermissionService;
//import com.example.springsecurity.service.UserService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.subject.SimplePrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//import org.crazycake.shiro.RedisCacheManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * @author 屈燃希
// * @version 1.0
// * @project
// */
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class MyRealm extends AuthorizingRealm {
//    @Resource
//    private UserService userService;
//    @Resource
//    private UserDataPermissionService userDataPermissionService;
//
//    @Autowired
//    private ShiroLogoutService shiroLogoutService;
//    private RedisCacheManager redisCacheManager;
//
//
//
//    @Autowired(required = false)
//    public void setRedisCacheManager(RedisCacheManager redisCacheManager) {
//        this.redisCacheManager = redisCacheManager;
//    }
//    @PostConstruct
//    private void initConfig() {
//        setAuthenticationCachingEnabled(false);
////        setAuthorizationCachingEnabled(true);
//        setCachingEnabled(true);
//        setCacheManager(redisCacheManager);
//    }
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        System.out.println("授权开始");
//        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
//        User userInfo = (User) principals.getPrimaryPrincipal();
////        for (Role sysRole : userInfo.getRoles()) {
////            simpleAuthorizationInfo.addRole(sysRole.getRoleName());
////        }
////        return  simpleAuthorizationInfo;
//        userService.doGetUserAuthorizationInfo(userInfo);
//        log.info("roles"+userInfo.getRoles());
//        simpleAuthorizationInfo.setRoles(userInfo.getRoles());
//        return simpleAuthorizationInfo;
//    }
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        System.out.println("开始认证");
//        String useName=(String)token.getPrincipal();
//        String password = new String((char[]) token.getCredentials());
//        log.info("user"+useName);
//        log.info("password"+password);
//        User userInfo = userService.findUserByName(useName);
//        log.info("userInfo"+userInfo.toString());
//        if (userInfo==null||!StringUtils.equals(password, userInfo.getPassword()))
//        {
//            log.info("error");
//            throw new IncorrectCredentialsException("用户名错误或者密码错误");
//        }
//
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                userInfo, //用户名
//                password, //密码
//                getName()  //realm name
//        );
//        List<UserDataPermissionKey> byUserId = this.userDataPermissionService.findByUserId(userInfo.getUserId());
//        Long[] deptIds = new Long[byUserId.size()];
//        for (int i = 0; i <byUserId.size(); i++) {
//            deptIds[i]=byUserId.get(i).getDeptId();
//            log.info("deptId"+deptIds[i]);
//        }
//
//        log.info("deptIds",deptIds);
//        userInfo.setDeptIds(deptIds);
//        return authenticationInfo;
//    }
//}

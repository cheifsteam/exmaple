//package com.example.spring_security.aspectj;
//
//import com.example.spring_security.annotation.DataScope;
//import com.example.spring_security.domain.SysRole;
//import com.example.spring_security.domain.UserInfo;
//import com.example.spring_security.sevice.UserInfoService;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.subject.Subject;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * @author 屈燃希
// * @version 1.0
// * @project
// */
//@Aspect
//@Component
//public class DataScopeAspect {
//    @Resource
//    private UserInfoService userInfoService;
//
//    /**
//     * 全部数据权限
//     */
//    public static final int DATA_SCOPE_ALL = 1;
//
//    /**
//     * Vip权限
//     */
//    public static final int DATA_SCOPE_CUSTOM = 2;
//    /**
//     * 数据权限过滤关键字
//     */
//    public static final String DATA_SCOPE = "dataScope";
//
//    @Before("@annotation(dataScope)")
//    public void doBefore(JoinPoint point, DataScope dataScope){
//
//    }
//    public void handleDataScope(JoinPoint joinPoint,DataScope dataScope){
//        Subject subject = SecurityUtils.getSubject();
//        if (subject!=null){
//            if (subject.hasRole("admin")){
//
//            }
//
//        }
//
//    }
//    public static  void dataScopeFilter(JoinPoint joinPoint, UserInfo userInfo,String userAlias){
//        StringBuilder sqlString =new StringBuilder();
//        for (SysRole role : userInfo.getRoleList()){
//             Integer id = role.getId();
//            if (DATA_SCOPE_ALL==id) {
//                sqlString = new StringBuilder();
//                break;
//            }
//            else if (DATA_SCOPE_CUSTOM==id){
//                sqlString.append("OR ")
//            }
//        }
//    }
//}

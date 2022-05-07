package com.example.springsecurity.aspectj;


import com.example.springsecurity.annotation.DataScope;
import com.example.springsecurity.domain.BaseEntity;
import com.example.springsecurity.domain.User;
import com.example.springsecurity.service.UserService;
import com.example.springsecurity.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;


/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Aspect
@Component
@Slf4j
public class DataScopeAspect {
    @Resource
    private UserService userInfoService;

    /**
     * 全部数据权限
     */
    public static final int DATA_SCOPE_ALL = 1;

    /**
     * Vip权限
     */
    public static final int DATA_SCOPE_CUSTOM = 2;
    /**
     * 数据权限过滤关键字
     */
    public static final String DATA_SCOPE = "dataScope";

    @Before("@annotation(dataScope)")
    public void doBefore(JoinPoint point, DataScope dataScope){
        clearDataScope(point);
        handleDataScope(point, dataScope);
    }
    public void handleDataScope(JoinPoint joinPoint,DataScope dataScope){
        Subject subject = SecurityUtils.getSubject();
         User user= (User) subject.getPrincipal();
        if (subject!=null){
            if (subject.hasRole("系统管理员")){
                dataScopeFilter(joinPoint, user );
            }

        }

    }
    public static  void dataScopeFilter(JoinPoint joinPoint, User userInfo){
        StringBuilder sqlString =new StringBuilder();
        log.info("dd"+ Arrays.toString(userInfo.getDeptIds()));
        sqlString.append(StringUtils.format(" DEPT_ID IN ({})" ,userInfo.getDeptIds()));
        log.info("sql"+sqlString);
        Object params = joinPoint.getArgs()[0];
        if (StringUtils.isNoneBlank(sqlString.toString())){
            BaseEntity baseEntity = (BaseEntity) params;
            baseEntity.getParams().put(DATA_SCOPE, sqlString.toString());
        }
    }
    /**
     * 拼接权限sql前先清空params.dataScope参数防止注入
     */
    private void clearDataScope(final JoinPoint joinPoint)
    {
        Object params = joinPoint.getArgs()[0];
        if (StringUtils.isNotNull(params) && params instanceof BaseEntity)
        {
            BaseEntity baseEntity = (BaseEntity) params;
            baseEntity.getParams().put(DATA_SCOPE, "");
        }
    }
}

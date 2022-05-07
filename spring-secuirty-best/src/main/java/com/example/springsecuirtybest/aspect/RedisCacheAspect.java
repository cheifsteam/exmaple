package com.example.springsecuirtybest.aspect;

import com.example.springsecuirtybest.annotation.CacheException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Aspect
@Component
@Order(2)
@Slf4j
public class RedisCacheAspect {

@Pointcut("execution(public * com.example.springsecuirtybest.core.redis.RedisCache.*(..))")
 public  void cacheAspect(){

 }
 @Around("cacheAspect()")
 public Object doRound(ProceedingJoinPoint joinPoint) throws Throwable {
     Signature signature = joinPoint.getSignature();
     MethodSignature methodSignature=(MethodSignature)signature;
     Method method =methodSignature.getMethod();
     Object result = null;
     try {
         result=joinPoint.proceed();
     } catch (Throwable throwable) {
        if (method.isAnnotationPresent(CacheException.class)){
            throw  throwable;
        }
        else {
            log.error(throwable.getMessage());
        }
     }
     return result;
 }


}

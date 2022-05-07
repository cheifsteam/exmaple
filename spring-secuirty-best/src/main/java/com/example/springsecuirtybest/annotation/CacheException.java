package com.example.springsecuirtybest.annotation;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;

import java.lang.annotation.*;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheException {
}

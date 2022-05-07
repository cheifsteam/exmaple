package com.example.springsecuirtybest.utils;

import java.util.UUID;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public  class IdUtils {
    //生成一个随机id
    public static String fastUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}

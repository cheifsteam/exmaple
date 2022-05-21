package com.example.spring_security.entity;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class MyResponse extends HashMap<String,Object> {
    private static final long serialVersionUID = -8713837118340960775L;

    public MyResponse code(HttpStatus status) {
        put("code", status.value());
        return this;
    }

    public MyResponse message(String message) {
        put("message", message);
        return this;
    }

    public MyResponse data(Object data) {
        put("data", data);
        return this;
    }

    public MyResponse success() {
        code(HttpStatus.OK);
        return this;
    }

    public MyResponse fail() {
        code(HttpStatus.INTERNAL_SERVER_ERROR);
        return this;
    }

    @Override
    public MyResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}

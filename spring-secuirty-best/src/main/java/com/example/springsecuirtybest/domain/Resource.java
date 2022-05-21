package com.example.springsecuirtybest.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Data
public class Resource implements Serializable {
    private  int id;
    private String name;
    private String url;

}

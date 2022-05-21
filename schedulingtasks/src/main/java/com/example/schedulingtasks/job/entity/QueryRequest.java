package com.example.schedulingtasks.job.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Data
@ToString
public class QueryRequest implements Serializable {
    private static final long serialVersionUID = -4869594085374385813L;
    /**
     * 当前页码
     */
    private int page = 1;
    /**
     * 当前也买你数据量
     */
    private int pageSize = 10;
    /**
     * 排序字段
     */
    private String field;
    /**
     * 排序规则 asc升序，desc降序
     */
    private String order;
}

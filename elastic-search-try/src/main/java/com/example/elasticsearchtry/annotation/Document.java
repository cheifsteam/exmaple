package com.example.elasticsearchtry.annotation;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
//标示映射到Elasticsearch文档上的领域对象
public @interface Document {
    //索引库名次，mysql中数据库的概念
    String indexName();
    //文档类型，mysql中表的概念
    String type() default "";
    //默认分片数
    short shards() default 5;
    //默认副本数量
    short replicas() default 1;
}

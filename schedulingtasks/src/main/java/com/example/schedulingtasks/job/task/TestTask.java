package com.example.schedulingtasks.job.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Slf4j
@Component
public class TestTask {

    public void test(String params) {
        log.info("我是带参数的test方法，正在被执行，参数为：{}", params);
    }

    public void test1() {
        log.info("我是不带参数的test1方法，正在被执行");
    }

    public void print(int i) {
        System.out.println("梳子"+i);
    }

}

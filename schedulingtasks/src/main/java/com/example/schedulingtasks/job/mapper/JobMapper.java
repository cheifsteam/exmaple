package com.example.schedulingtasks.job.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schedulingtasks.job.entity.Job;

import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public interface JobMapper extends BaseMapper<Job> {

    /**
     * 获取定时任务列表
     *
     * @return 定时任务列表
     */
    List<Job> queryList();
}
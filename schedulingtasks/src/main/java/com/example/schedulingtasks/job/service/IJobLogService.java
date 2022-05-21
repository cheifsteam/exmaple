package com.example.schedulingtasks.job.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.schedulingtasks.job.entity.Job;
import com.example.schedulingtasks.job.entity.JobLog;
import com.example.schedulingtasks.job.entity.QueryRequest;
import org.springframework.scheduling.annotation.Async;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public interface IJobLogService extends IService<JobLog> {
    /**
     * 获取定时任务日志分页数据
     *
     * @param request
     * @param jobLog
     * @return 定时任务日志分页数据
     */
    IPage<JobLog> findJobLogs(QueryRequest request,JobLog jobLog);

    /**
     * 保存定时任务日志
     *
     * @param log 定时任务日志
     */
    void saveJobLog(JobLog log);

    /**
     * 删除定时任务日志
     *
     * @param jobLogIds 定时任务日志id数组
     */
    void deleteJobLogs(String[] jobLogIds);

}

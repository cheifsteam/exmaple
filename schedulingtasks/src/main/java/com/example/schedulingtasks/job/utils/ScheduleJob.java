package com.example.schedulingtasks.job.utils;

import com.example.schedulingtasks.common.utils.SpringContextUtil;
import com.example.schedulingtasks.job.entity.Job;
import com.example.schedulingtasks.job.entity.JobLog;
import com.example.schedulingtasks.job.service.IJobLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Slf4j
public class ScheduleJob extends QuartzJobBean {

    private  final ThreadPoolTaskExecutor scheduleJobExecutorService = SpringContextUtil.getBean("MyThreadPoolTaskExecutor",ThreadPoolTaskExecutor.class);
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        Job scheduleJob =(Job) context.getMergedJobDataMap().get(Job.JOB_PARAM_KEY);
        //获取spring bean
        IJobLogService scheduleJobLogService =SpringContextUtil.getBean(IJobLogService.class);
        JobLog jobLog =new JobLog();
        jobLog.setJobId(scheduleJob.getJobId());
        jobLog.setBeanName(scheduleJob.getBeanName());
        jobLog.setMethodName(scheduleJob.getMethodName());
        jobLog.setParams(scheduleJob.getParams());
        jobLog.setCreateTime(new Date());

        long startTime =System.currentTimeMillis();

        try {
            log.info("任务执行，任务ID：{}",scheduleJob.getJobId());
            ScheduleRunnable task = new ScheduleRunnable(scheduleJob.getBeanName(),scheduleJob.getMethodName(),scheduleJob.getParams());
            Future<?> future = scheduleJobExecutorService.submit(task);
            future.get();
            long times =System.currentTimeMillis() -startTime;
            jobLog.setTimes(times);
            jobLog.setStatus(JobLog.JOB_SUCCESS);
            log.info("任务执行完毕，任务ID，{} 总共消耗 {}毫秒" ,scheduleJob.getJobId(),times);
        }catch (Exception e) {
            log.error("任务执行失败，任务ID: "+scheduleJob.getJobId(),e);
            long times =System.currentTimeMillis() -startTime;
            jobLog.setTimes(times);
            jobLog.setStatus(JobLog.JOB_FAIL);
            jobLog.setError(StringUtils.substring(e.toString(),0,2000));

        }finally {
            scheduleJobLogService.saveJobLog(jobLog);
        }
    }
}

package com.example.schedulingtasks.job.utils;

import com.example.schedulingtasks.job.entity.Job;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Slf4j
public abstract  class ScheduleUtils {
    private  static final String JOB_NAME_PREFIX ="TASK_";

    /**
     * 获取触发器 key
     */
    public   static TriggerKey getTriggerKey(Long jobId){
        return TriggerKey.triggerKey(JOB_NAME_PREFIX+jobId);
    }
    public static JobKey getJobKey(Long jobId){
        return JobKey.jobKey(JOB_NAME_PREFIX+jobId);
    }
    public static CronTrigger getCronTrigger(Scheduler scheduler ,Long jobId) {
        try {
            return (CronTrigger) scheduler.getTrigger(getTriggerKey(jobId));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void createScheduleJob(Scheduler scheduler , Job scheduleJob) {
        try {
            JobDetail jobDetail = JobBuilder.newJob(ScheduleJob.class).withIdentity(getJobKey(scheduleJob.getJobId())).build();

            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression()).withMisfireHandlingInstructionDoNothing();

            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(scheduleJob.getJobId())).withSchedule(cronScheduleBuilder).build();

            jobDetail.getJobDataMap().put(Job.JOB_PARAM_KEY,scheduleJob);

            scheduler.scheduleJob(jobDetail,cronTrigger);


            // 暂停任务
            if (scheduleJob.getStatus().equals(Job.ScheduleStatus.PAUSE.getValue())) {
                pauseJob(scheduler, scheduleJob.getJobId());
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }


    }

    public static void updateScheduleJob(Scheduler scheduler , Job scheduleJob)  {
        try {
            TriggerKey triggerkey = getTriggerKey(scheduleJob.getJobId());

            CronScheduleBuilder cronScheduleBuilder =CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression()).withMisfireHandlingInstructionDoNothing();

            CronTrigger cronTrigger =getCronTrigger(scheduler,scheduleJob.getJobId());

            if (cronTrigger == null) {
                throw new SchedulerException("获取cron表达式失败");
            } else {
                cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerkey).withSchedule(cronScheduleBuilder).build();
                cronTrigger.getJobDataMap().put(Job.JOB_PARAM_KEY,scheduleJob);
            }
            scheduler.rescheduleJob(triggerkey,cronTrigger);

            // 暂停任务
            if (scheduleJob.getStatus().equals(Job.ScheduleStatus.PAUSE.getValue())) {
                pauseJob(scheduler, scheduleJob.getJobId());
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    /**
     * 立即执行任务
     */
    public static void run (Scheduler scheduler ,Job scheduleJob) {
        try {
            JobDataMap dataMap =new JobDataMap();
            dataMap.put(Job.JOB_PARAM_KEY,scheduleJob);
            scheduler.triggerJob(getJobKey(scheduleJob.getJobId()),dataMap);
        } catch (SchedulerException e) {
            log.error("执行定时任务失败",e);
        }
    }
    /**
     * 暂停任务
     */
    public static  void pauseJob(Scheduler scheduler,Long jobId) {
        try {
            scheduler.pauseJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            log.error("暂停定时任务失败",e);
        }
    }
    /**
     * 恢复任务
     */
    public static void  resumeJob(Scheduler scheduler,Long jobId) {
        try {
            scheduler.resumeJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            log.error("恢复定时任务失败",e);
        }
    }
    /**
     * 删除定时任务
     */
    public static  void  deleteScheduleJob(Scheduler scheduler, Long jobId) {
        try {
            scheduler.deleteJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            log.error("删除定时任务失败",e);
        }
    }
}


package com.example.schedulingtasks.job.configure;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Configuration
@RequiredArgsConstructor
public class ScheduleConfigure {
    private final DynamicRoutingDataSource dynamicRoutingDataSource ;
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean factory =new SchedulerFactoryBean();
        DataSource quartz =dynamicRoutingDataSource.getDataSource("quartz");
        factory.setDataSource(quartz);

        //quartz参数
        Properties properties =new Properties();
        properties.put("org.quartz.scheduler.instanceName", "MyScheduler");
        properties.put("org.quartz.scheduler.instanceId", "AUTO");
        //线程池配置
        properties.put("org.quartz.threadPool.class","org.quartz.simpl.SimpleThreadPool");
        properties.put("org.quartz.threadPool.threadCount","20");
        properties.put("org.quartz.threadPool.threadPriority","5");
        // JobStore配置
        properties.put("org.quartz.jobStore.class","org.springframework.scheduling.quartz.LocalDataSourceJobStore");
        // 集群配置
        properties.put("org.quartz.jobStore.isClustered", "true");
        properties.put("org.quartz.jobStore.clusterCheckinInterval", "15000");
        properties.put("org.quartz.jobStore.maxMisfiresToHandleAtATime", "1");

        properties.put("org.quartz.jobStore.misfireThreshold", "12000");
        properties.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
        factory.setQuartzProperties(properties);
        factory.setSchedulerName("QRX_Scheduler");
        // 延时启动
        factory.setStartupDelay(1);
        factory.setApplicationContextSchedulerContextKey("applicationContextKey");
        // 启动时更新己存在的 Job
        factory.setOverwriteExistingJobs(true);
        // 设置自动启动，默认为 true
        factory.setAutoStartup(true);
        return  factory;
    }
}

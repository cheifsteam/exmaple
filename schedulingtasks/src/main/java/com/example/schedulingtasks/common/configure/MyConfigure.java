package com.example.schedulingtasks.common.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Configuration(proxyBeanMethods = false)
public class MyConfigure {

    @Bean("MyThreadPoolTaskExecutor")
        public ThreadPoolTaskExecutor MyThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);//核心线程池数
        threadPoolTaskExecutor.setMaxPoolSize(20);//最大线程池数
        threadPoolTaskExecutor.setQueueCapacity(200);//任务队列的容量
        threadPoolTaskExecutor.setKeepAliveSeconds(30);//非核心线程的存活时间
        threadPoolTaskExecutor.setThreadNamePrefix("my-shiro");
        //设置shutdown时是否等到所有任务完成再真正关闭
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        //当 setWaitForTasksToCompleteOnShutdown(true)时，setAwaitTerminationSeconds 设置在 shutdown 之后最多等待多长时间后再真正关闭线程池
        threadPoolTaskExecutor.setAwaitTerminationSeconds(60);
        //rejectedExecutionHandler字段用于配置拒绝策略，常用的拒绝策略如下：
        //
        //AbortPolicy，用于被拒绝任务的处理程序，它将抛出RejectedExecutionException。
        //CallerRunsPolicy，用于被拒绝任务的处理程序，它直接在execute方法的调用线程中运行被拒绝的任务。
        //DiscardOldestPolicy，用于被拒绝任务的处理程序，它放弃最旧的未处理请求，然后重试execute。
        //DiscardPolicy，用于被拒绝任务的处理程序，默认情况下它将丢弃被拒绝的任务。
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}

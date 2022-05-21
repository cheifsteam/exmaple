package com.example.schedulingtasks.job.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 屈燃希
 * @version 1.0
 * @project "调度日志信息表"
 */
@Data
@TableName("e_job_log")
public class JobLog implements Serializable {
    /**
     * 任务执行成功
     */
    public   static final  String JOB_SUCCESS="0";
    /**
     * 任务执行失败
     */
    public static final String JOB_FAIL="1";
    private static final long serialVersionUID = -7114915445674333148L;
    @TableId(value = "LOG_ID",type = IdType.AUTO)
    private Long longId;
    @TableField("job_id")
    private Long jobId;

    @TableField("bean_name")
    private String beanName;

    @TableField("params")
    private String params;

    @TableField("method_name")
    private String methodName;

    @TableField("status")
    private String status;

    @TableField("error")
    private String error;

    @TableField("times")
    private Long times;

    @TableField("create_time")
    private Date createTime;

    private transient String crateTimeFrom;
    private transient String createTimeTo;
}

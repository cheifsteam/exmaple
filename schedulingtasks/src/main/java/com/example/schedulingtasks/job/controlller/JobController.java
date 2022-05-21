package com.example.schedulingtasks.job.controlller;

import com.example.schedulingtasks.job.entity.Job;
import com.example.schedulingtasks.job.entity.MyResponse;
import com.example.schedulingtasks.job.entity.QueryRequest;
import com.example.schedulingtasks.job.service.IJobLogService;
import com.example.schedulingtasks.job.service.IJobService;
import com.google.common.base.Strings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.quartz.CronExpression;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("job")
public class JobController extends BaseController{

    private  final IJobService jobService;
    @GetMapping
    public MyResponse jobList(QueryRequest request, Job job) {
        return new MyResponse().success().data(getDataTable(jobService.findJobs(request,job)));
    }
    @GetMapping("cron/check")
    public  boolean checkCron(String cron) {
        try {
            return CronExpression.isValidExpression(cron);
        } catch (Exception e) {
            return false;
        }
    }
    @PostMapping
    public MyResponse addJob(@Valid Job job) {
        jobService.createJob(job);
        return new MyResponse().success();
    }

    @GetMapping("delete/{jobIds}")
    public MyResponse deleteJob(@NotBlank(message = "{required}") @PathVariable String jobIds) {
        jobService.deleteJobs(StringUtils.split(jobIds, ","));
        return new MyResponse().success();
    }

    @PostMapping("update")
    public MyResponse updateJob(@Valid Job job) {
        jobService.updateJob(job);
        return new MyResponse().success();
    }

    @GetMapping("run/{jobIds}")
    public MyResponse runJob(@NotBlank(message = "{required}") @PathVariable String jobIds) {
        jobService.run(jobIds);
        return new MyResponse().success();
    }

    @GetMapping("pause/{jobIds}")
    public MyResponse pauseJob(@NotBlank(message = "{required}") @PathVariable String jobIds) {
        jobService.pause(jobIds);
        return new MyResponse().success();
    }

    @GetMapping("resume/{jobIds}")
    public MyResponse resumeJob(@NotBlank(message = "{required}") @PathVariable String jobIds) {
        jobService.resume(jobIds);
        return new MyResponse().success();
    }

}

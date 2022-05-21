package com.example.schedulingtasks.job.controlller;

import com.example.schedulingtasks.job.entity.JobLog;
import com.example.schedulingtasks.job.entity.MyResponse;

import com.example.schedulingtasks.job.entity.QueryRequest;
import com.example.schedulingtasks.job.service.IJobLogService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @author MrBird
 */
@Slf4j
@Validated
@RestController
@RequestMapping("jobLog")
@RequiredArgsConstructor
public class JobLogController extends BaseController {

    private final IJobLogService jobLogService;

    @GetMapping
    public MyResponse jobLogList(QueryRequest request, JobLog log) {
        return new MyResponse().success()
                .data(getDataTable(jobLogService.findJobLogs(request, log)));
    }

    @GetMapping("delete/{jobIds}")
    public MyResponse deleteJobLog(@NotBlank(message = "{required}") @PathVariable String jobIds) {
        jobLogService.deleteJobLogs(StringUtils.split(jobIds, ","));
        return new MyResponse().success();
    }

}

package com.example.springaoplog.common.handler;

import com.example.springaoplog.common.constant.ResponseStatus;
import com.example.springaoplog.common.entity.response.ResponseResult;
import com.example.springaoplog.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public ResponseResult<BusinessException> processBusinessException(BusinessException businessException) {
        log.error(businessException.getLocalizedMessage());
        return ResponseResult.fail(null, businessException.getLocalizedMessage()==null
                ? ResponseStatus.HTTP_STATUS_500.getDescription()
                :businessException.getLocalizedMessage());
    }
    @ResponseBody
    @ExceptionHandler
    public ResponseResult<Exception> processException(Exception exception)
    {
        log.error(exception.getLocalizedMessage());
        return ResponseResult.fail(null,ResponseStatus.HTTP_STATUS_500.getDescription());
    }

}

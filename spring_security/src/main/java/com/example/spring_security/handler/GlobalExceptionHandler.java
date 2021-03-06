package com.example.spring_security.handler;

import com.example.spring_security.entity.MyResponse;
import com.example.spring_security.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.List;
import java.util.Set;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public MyResponse handlerException(Exception e)
    {
        log.error("系统内部异常，异常信息",e);
        return new MyResponse().code(HttpStatus.INTERNAL_SERVER_ERROR).message("系统内部异常");
    }
    @ExceptionHandler(value = MyException.class)
    public MyResponse handlerMyException(MyException e)
    {
        log.debug("系统错误",e);
        return new MyResponse().code(HttpStatus.INTERNAL_SERVER_ERROR).message("系统错误");
    }
    /**
     * 统一处理请求参数校验(实体对象传参-form)
     *
     * @param e BindException
     * @return MyResponse
     */
    @ExceptionHandler(BindException.class)
    public MyResponse validExceptionHandler(BindException e) {
        StringBuilder message=new StringBuilder();
        List<FieldError> fieldErrors=e.getBindingResult().getFieldErrors();
        for (FieldError error:fieldErrors)
        {
            message.append(error.getField()).append(error.getDefaultMessage()).append(",");
        }
        message=new StringBuilder(message.substring(0,message.length()-1));
        return new MyResponse().code(HttpStatus.BAD_REQUEST).message(message.toString());
    }
    /**
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return MyResponse
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public MyResponse handlerConstraintViolationException(ConstraintViolationException e){
        StringBuilder message=new StringBuilder();
        Set<ConstraintViolation<?>> violations=e.getConstraintViolations();
        for (ConstraintViolation<?> violation: violations) {
            Path path =violation.getPropertyPath();
            String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(),".");
            message.append(pathArr[1]).append(violation.getMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return  new MyResponse().code(HttpStatus.BAD_REQUEST).message(message.toString());
    }
    /**
     * 统一处理请求参数校验(json)
     *
     * @param e ConstraintViolationException
     * @return MyResponse
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MyResponse handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder message = new StringBuilder();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        log.error(message.toString(), e);
        return new MyResponse().code(HttpStatus.BAD_REQUEST).message(message.toString());
    }


}

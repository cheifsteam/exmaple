package com.example.springaoplog.common.exception;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class BusinessException extends RuntimeException{

    public  BusinessException(){
        super();
    }

    public BusinessException(final String message)
    {
        super(message);
    }

    public BusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BusinessException(final Throwable cause) {
        super(cause);
    }

    protected BusinessException(final String message, final Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

package com.example.spring_security.exception;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class MyException extends RuntimeException{
    private static final long serialVersionUID = -994962710559017255L;

    public MyException(String message) {
        super(message);
    }
}

package com.example.springvalidation.i18n.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Data
@Builder
public class ExceptionData
{
    @Singular
    private final List<Object> errors;

}

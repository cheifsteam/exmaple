package com.example.schedulingtasks.common.validator;

import com.example.schedulingtasks.common.annotation.IsCron;
import org.quartz.CronExpression;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 校验是否为合法的 Cron表达式
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class CronValidator implements ConstraintValidator<IsCron,String> {

    @Override
    public void initialize(IsCron constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            return CronExpression.isValidExpression(s);
        }catch (Exception e) {
            return false;
        }
    }
}

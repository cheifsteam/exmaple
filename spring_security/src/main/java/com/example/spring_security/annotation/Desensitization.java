package com.example.spring_security.annotation;


import com.example.spring_security.entity.DesensitizationType;
import org.apache.logging.log4j.util.Strings;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author MrBird
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Desensitization {

    /**
     * 脱敏规则类型
     */
    DesensitizationType type();

    /**
     * 附加值, 自定义正则表达式等
     */
    String[] attach() default Strings.EMPTY;
}

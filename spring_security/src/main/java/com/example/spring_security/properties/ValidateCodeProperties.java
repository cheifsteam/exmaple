package com.example.spring_security.properties;

import lombok.Data;
import org.hibernate.type.ImageType;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Data
@Configuration
public class ValidateCodeProperties {
    /**
     * 验证码有效时间，单位秒
     */
    @DurationUnit(ChronoUnit.SECONDS)
    private Duration time = Duration.ofSeconds(120);
    /**
     * 验证码类型，可选值 png和 gif
     */
    private String type = "png";
    /**
     * 图片宽度，px
     */
    private Integer width = 130;
    /**
     * 图片高度，px
     */
    private Integer height = 48;
    /**
     * 验证码位数
     */
    private Integer length = 4;
    /**
     * 验证码值的类型
     * 1. 数字加字母
     * 2. 纯数字
     * 3. 纯字母
     */
    private Integer charType = 2;
}

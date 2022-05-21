package com.example.spring_security.sevice;

import com.example.spring_security.exception.MyException;
import com.example.spring_security.properties.ValidateCodeProperties;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Service
@RequiredArgsConstructor
public class ValidateCodeService {
    private RedisService redisService;

    private final   ValidateCodeProperties validateCodeProperties;

    @Autowired(required = false)
    public void setRedisService(RedisService redisService){
        this.redisService=redisService;
    }
    public void create(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        String key=session.getId();
        ValidateCodeProperties code=validateCodeProperties;
        setHeader(response,code.getType());
        Captcha captcha=creatCaptcha(code);
        String codeKey="febs_captcha_"+key;
        String codeValue= StringUtils.lowerCase(captcha.text());
        redisService.set(codeKey,codeValue,code.getTime().getSeconds());
        captcha.out(response.getOutputStream());
    }

    private Captcha creatCaptcha(ValidateCodeProperties code) {
        Captcha captcha;
        if (StringUtils.equalsIgnoreCase(code.getType(),"gif" )) {
            captcha =new GifCaptcha(code.getWidth(),code.getHeight(),code.getLength());
        }else {
            captcha =new SpecCaptcha(code.getWidth(),code.getHeight(),code.getLength());
        }
        captcha.setCharType(code.getCharType());
        return captcha;
    }

    private void setHeader(HttpServletResponse response,String type) {
        if (StringUtils.equalsIgnoreCase(type,"gif")) {
            response.setContentType(MediaType.IMAGE_GIF_VALUE);
        } else {
            response.setContentType(MediaType.IMAGE_PNG_VALUE);
        }
        response.setHeader(HttpHeaders.PRAGMA,"No-cache");
        response.setHeader(HttpHeaders.CACHE_CONTROL,"No-cache");
        response.setDateHeader(HttpHeaders.EXPIRES,0L);
    }
    public void check(String key,String value) {
        if (StringUtils.isBlank(value)) {
            throw new MyException("请输入验证码");
        }
        String codeKey = "febs_captcha_"+ key;
        Object codeInRedis = redisService.get(codeKey);
        if (codeInRedis == null) {
            throw new MyException("验证码已过期");
        }
        if (!StringUtils.equalsIgnoreCase(value,String.valueOf(codeInRedis))) {
            throw new MyException("验证码不正确");
        }
    }
}


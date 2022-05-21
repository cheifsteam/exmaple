package com.example.springcloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Request;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Slf4j
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        log.info("--->>> TokenFilter {},{}", request.getMethod(), request.getRequestURL().toString());
        String token = request.getParameter("token");// 获取请求的参数

        if (StringUtils.isNotBlank(token)) {
            context.setSendZuulResponse(true); //对请求进行路由
            context.setResponseStatusCode(200);
            context.set("isSuccess", true);
            return null;
        } else {
            context.setSendZuulResponse(false); //不对其进行路由
            context.setResponseStatusCode(400);
            context.setResponseBody("token is empty");
            context.set("isSuccess", false);
            return null;
        }
    }
}

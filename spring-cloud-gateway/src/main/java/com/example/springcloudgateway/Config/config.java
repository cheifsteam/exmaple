package com.example.springcloudgateway.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Configuration
public class config {
    private static final Logger log= LoggerFactory.getLogger(config.class);
    @Bean
    KeyResolver userKeyResolver() {
        log.info("限制user+");
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }
//    @Bean
//    public KeyResolver ipKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
//    }
}

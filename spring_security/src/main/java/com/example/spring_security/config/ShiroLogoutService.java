package com.example.spring_security.config;

import com.example.spring_security.domain.UserInfo;
import com.example.spring_security.sevice.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.PrincipalCollection;
import org.crazycake.shiro.RedisCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MrBird
 */
@Slf4j
@Service
public class ShiroLogoutService {

    private RedisService redisService;

    @Autowired(required = false)
    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    public void cleanCacheFragment(PrincipalCollection principals) {
        UserInfo principal = (UserInfo) principals.getPrimaryPrincipal();
        String key = RedisCacheManager.DEFAULT_CACHE_KEY_PREFIX
                + MyRealm.class.getName()
                + "." + "authenticationCache" + ":"+ principal.getId();
        System.out.println(redisService.get(key));
        redisService.del(key);
        log.info("async clean up user cache fragment,cache key: [{}]", key);
    }
}
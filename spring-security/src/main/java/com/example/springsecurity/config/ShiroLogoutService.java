//package com.example.springsecurity.config;
//import com.example.springsecurity.domain.User;
//import com.example.springsecurity.service.RedisService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.crazycake.shiro.RedisCacheManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @author MrBird
// */
//@Slf4j
//@Service
//public class ShiroLogoutService {
//
//    private RedisService redisService;
//
//    @Autowired(required = false)
//    public void setRedisService(RedisService redisService) {
//        this.redisService = redisService;
//    }
//
//    public void cleanCacheFragment(PrincipalCollection principals) {
//        User principal = (User) principals.getPrimaryPrincipal();
//        String key = RedisCacheManager.DEFAULT_CACHE_KEY_PREFIX
//                + MyRealm.class.getName()
//                + "." + "authenticationCache" + ":"+ principal.getUserId();
//        System.out.println(redisService.get(key));
//        redisService.del(key);
//        log.info("async clean up user cache fragment,cache key: [{}]", key);
//    }
//}

package com.example.spring_security.config;

import com.sun.istack.Nullable;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.CookieManager;
import java.nio.charset.StandardCharsets;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@RequiredArgsConstructor
@Configuration
public class ShiroConfigure {
    /**
     * remember key
     * 生成方式：
     * String encryptKey = RandomStringUtils.randomAlphanumeric(15);
     * byte[] encryptKeyBytes = encryptKey.getBytes(StandardCharsets.UTF_8);
     * String rememberKey = Base64Utils.encodeToString(Arrays.copyOf(encryptKeyBytes, 16));
     */
    private final static String REMEMBER_ME_KEY = "M1RIN2FVNGt6T2lRU2VNAA==";
    public RedisManager redisManager(){
         RedisManager redisManager = new RedisManager();
         redisManager.setHost("127.0.0.1:6379");
         return redisManager;
    }
    @Bean
    public RedisCacheManager redisCacheManager(){
         RedisCacheManager redisCacheManager = new RedisCacheManager();
         redisCacheManager.setExpire(36000000);
         redisCacheManager.setRedisManager(redisManager());
         return redisCacheManager;
    }
    public CredentialsMatcher getCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(MyRealm myRealm,@Nullable RedisCacheManager redisCacheManager, DefaultWebSessionManager sessionManager){
        myRealm.setCredentialsMatcher(getCredentialsMatcher());
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 配置 SecurityManager，并注入 shiroRealm
        securityManager.setRealm(myRealm);
        // 配置 shiro session管理器
        securityManager.setSessionManager(sessionManager);
        // 配置 缓存管理类 cacheManager
        securityManager.setCacheManager(redisCacheManager );
        // 配置 rememberMeCookie
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }
    @Bean
    public RedisSessionDAO redisSessionDAO(){
         RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
         redisSessionDAO.setRedisManager(redisManager());
         return redisSessionDAO;
    }
    @Bean
    public MemorySessionDAO memorySessionDAO() {
         MemorySessionDAO memorySessionDAO = new MemorySessionDAO();
         return memorySessionDAO;
    }
    @Bean
    public DefaultWebSessionManager defaultWebSessionManager(@Nullable RedisSessionDAO redisSessionDAO, @Nullable MemorySessionDAO memorySessionDAO) {
        DefaultWebSessionManager sessionManager=new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(36000000);
        sessionManager.setSessionDAO(redisSessionDAO!=null?redisSessionDAO:memorySessionDAO);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    /**
     * cookie管理对象
     *
     * @return CookieRememberMeManager
     */
    private SimpleCookie rememberMeCookie(){
       SimpleCookie simpleCookie=new SimpleCookie("rememberMe");
       simpleCookie.setMaxAge((int)36000000 );
       return simpleCookie;
    }
    /**
     * cookie管理对象
     *
     * @return CookieRememberMeManager
     */
    public CookieRememberMeManager rememberMeManager(){
         CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
         cookieRememberMeManager.setCookie(rememberMeCookie());
         cookieRememberMeManager.setCipherKey(REMEMBER_ME_KEY.getBytes());
         return cookieRememberMeManager;
    }
}

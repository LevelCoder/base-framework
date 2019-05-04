package com.aibiancheng.accredit;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:登录认证验证器
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/21
 */
public class RetryLimitCredentialsMatcher extends HashedCredentialsMatcher {

    /**
     * 引入log日志
     */
    private static Logger logger = LoggerFactory.getLogger(RetryLimitCredentialsMatcher.class);

    /**
     * 登录重试次数缓存记录
     */
    private Cache<String, AtomicInteger> loginRetryCache;

    /**
     * 设置最大登录重试次数
     */
    private int maxRetryCount = 5;


    public void setMaxRetryCount(int maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
    }

    /**
     * 定义空的构造器
     */
    public RetryLimitCredentialsMatcher(){ }

    /**
     *
     * @param cacheManager
     * @param maxRetryCount 最大尝试次数
     */
    public RetryLimitCredentialsMatcher(CacheManager cacheManager, int maxRetryCount) {
        loginRetryCache = cacheManager.getCache(String.valueOf(maxRetryCount));//尝试获取cache,没有则新建
        this.maxRetryCount = maxRetryCount;
    }

    public RetryLimitCredentialsMatcher(CacheManager cacheManager){
        this(cacheManager,5);
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String) token.getPrincipal();
        AtomicInteger retryCount = loginRetryCache.get(username) == null ? new AtomicInteger(0) : loginRetryCache.get(username);
        logger.info("retryCount:{}, username:{}",retryCount,username);

        if (retryCount.incrementAndGet() > this.maxRetryCount) {
            logger.warn("username: {} tried to login more than {} times in perid", username,this.maxRetryCount);
            throw new ExcessiveAttemptsException();
        }

        boolean matches = super.doCredentialsMatch(token, info);

        if (matches) {
            loginRetryCache.remove(username);
        } else {
            loginRetryCache.put(username, retryCount);
            logger.info(String.valueOf(retryCount.get()));
        }
        return matches;
    }
}

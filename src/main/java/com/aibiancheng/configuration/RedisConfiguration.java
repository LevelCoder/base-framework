package com.aibiancheng.configuration;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:redis 缓存配置
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/1
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {

    //TODO:注入jedisPool 进行操作redis  通过 适配器模式
    //TODO:注入spring redisTemplate 模版进行操作redis  通过aop切面模式




}

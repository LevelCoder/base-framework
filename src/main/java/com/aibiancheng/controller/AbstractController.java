package com.aibiancheng.controller;

import com.aibiancheng.entity.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述:基础控制层:所有控制层都需要继承此控制层.实现日志统一入口
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public abstract class AbstractController {

    /**
     * 引入日志
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 获取用户信息
     * @return
     */
    protected UserEntity getUser() {
        return (UserEntity) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取用户id
     * @return
     */
    protected Long getUserId() {
        return getUser().getId();
    }
}

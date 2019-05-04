package com.aibiancheng.service;

import com.aibiancheng.entity.UserEntity;
import com.aibiancheng.entity.UserTokenEntity;
import com.aibiancheng.model.accredit.AccreditCustomUser;
import org.apache.shiro.authz.SimpleAuthorizationInfo;

import java.util.Set;

/**
 * 描述:
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/21
 */
public interface ShiroService {

    /**
     * 获取用户授权信息
     * @param id
     * @return
     */
    SimpleAuthorizationInfo findUserAuthorizationInfo(Long id);

    /**
     * 根据token查询用户token对象
     * @param token
     * @return
     */
    UserTokenEntity findByToken(String token);

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    UserEntity findUserInfoByUserId(Long userId);

    /**
     * 根据用户id封装自定义账户信息
     * @param userId
     * @return
     */
    AccreditCustomUser findAccreditCustomUser(Long userId);

    /**
     * 更新token有效期
     * @param token
     */
    void updateToken(UserTokenEntity token);
}

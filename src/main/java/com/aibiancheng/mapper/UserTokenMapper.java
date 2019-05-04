package com.aibiancheng.mapper;

import com.aibiancheng.entity.UserTokenEntity;

/**
 * 描述:
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/22
 */
public interface UserTokenMapper {

    /**
     * 根据token查询信息
     * @param token
     * @return
     */
    UserTokenEntity findByToken(String token);

    /**
     * 插入token信息
     * @param userTokenEntity
     */
    void saveByEntity(UserTokenEntity userTokenEntity);

    /**
     * 根据用户id查询是否已经生成token信息
     * @param userId
     * @return
     */
    UserTokenEntity findUserTokenByUserId(Long userId);

    /**
     * 更新token信息
     * @param userTokenEntity
     */
    void updateByEntity(UserTokenEntity userTokenEntity);
}

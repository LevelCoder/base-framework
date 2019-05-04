package com.aibiancheng.mapper;

import com.aibiancheng.entity.UserLocalAuthEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述:用户基本账户授权mapper
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public interface UserLocalAuthMapper {

    /**
     * 根据用户名查询用户账户信息
     * @param userName
     * @return
     */
    UserLocalAuthEntity findUserLocalAuthInfoByuserName(String userName);

    /**
     * 批量插入账户
     * @param userLocalAuthEntityList
     */
    void saveBatchByEntity(List<UserLocalAuthEntity> userLocalAuthEntityList);

    /**
     * 根据用户id删除账户信息
     * @param userId
     */
    void deleteUserLocalAuthByUserId(Long userId);

    /**
     * 根据用户id查询所有账户信息
     * @param userId
     * @return
     */
    List<UserLocalAuthEntity> findUserLocalAuthListByUserId(Long userId);

    /**
     * 批量更新账户信息
     * @param userLocalAuthEntityList
     */
    void updateBatchByEntity(List<UserLocalAuthEntity> userLocalAuthEntityList);

    /**
     * 根据用户名,用户id查询用户账户信息
     * @param userId
     * @param userPhone
     * @return
     */
    UserLocalAuthEntity findUserLocalAuthInfoByMap(@Param("userId") Long userId, @Param("loginName") String userPhone);
}

package com.aibiancheng.mapper;

import com.aibiancheng.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

/**
 * 描述:用户mapper
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public interface UserMapper {

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    UserEntity findUserInfoByUserId(Long userId);

    /**
     * 根据用户id查询用户状态
     * @param userId
     * @return
     */
    Byte findUserStateByUserId(Long userId);

    /**
     * 插入用户带返回主键id 用户本地账户 userId绑定
     * @param userEntity
     * @return
     */
    Long insertByEntity(UserEntity userEntity);

    /**
     * 根据用户id删除用户信息
     * @param userId
     */
    void deleteUserByUserId(Long userId);

    /**
     * 修改用户信息
     * @param userEntity
     */
    void updateSelective(UserEntity userEntity);

    /**
     * 变更用户状态
     * @param userId
     * @param userState
     */
    void changeUserState(@Param("userId") Long userId, @Param("userState") byte userState);

    /**
     * 验证邮箱是否存在
     * @param userEmail
     * @return
     */
    int findUserEmailExist(String userEmail);

    /**
     * 验证手机号是否存在
     * @param userPhone
     * @return
     */
    int findUserPhoneExist(String userPhone);

    /**
     * 验证用户名是否存在
     * @param userName
     * @return
     */
    int findUserNameExist(String userName);
}

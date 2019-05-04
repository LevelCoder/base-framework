package com.aibiancheng.extension;

import com.aibiancheng.entity.UserEntity;
import com.aibiancheng.model.bo.user.AddUserBO;

/**
 * 描述:用户延展类
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/2
 */
public class UserExtension {

    /**
     * 新增用户
     * @param addUserBO
     * @return
     */
    public static UserEntity addUser(AddUserBO addUserBO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setNickName(addUserBO.getNickName());
        userEntity.setUserAddress(addUserBO.getUserAddress());
        userEntity.setUserBirth(addUserBO.getUserBirth());
        userEntity.setUserEmail(addUserBO.getUserEmail());
        userEntity.setUserPhone(addUserBO.getUserPhone());
        userEntity.setUserPhoto(addUserBO.getUserPhoto());
        userEntity.setUserState((byte) 2);
        userEntity.setUserType(addUserBO.getUserType());
        return userEntity;
    }
}

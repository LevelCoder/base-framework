package com.aibiancheng.extension;

import com.aibiancheng.entity.UserLocalAuthEntity;
import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * 描述:用户本地账户延展累
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/2
 */
public class UserLocalAuthExtension {

    /**
     * 新增用户密码
     * @param userId        用户自增ID
     * @param loginName    用户登陆名 (用户名/邮箱/手机号)
     * @param passWord     用户登陆密码(系统分配用户默认为123456)
     * @return
     */
    public static UserLocalAuthEntity addUserLocalAuth(Long userId, String loginName, String passWord,String salt) throws Exception {
        UserLocalAuthEntity userLocalAuthEntity = new UserLocalAuthEntity();
        userLocalAuthEntity.setUserId(userId);
        userLocalAuthEntity.setLoginName(loginName);
        userLocalAuthEntity.setPassWord(new Sha256Hash(passWord+loginName,salt).toHex());
        userLocalAuthEntity.setIsVerified((byte) 2);
        userLocalAuthEntity.setSalt(salt);
        return userLocalAuthEntity;
    }
}

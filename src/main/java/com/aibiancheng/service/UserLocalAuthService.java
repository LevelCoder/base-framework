package com.aibiancheng.service;

import com.aibiancheng.entity.UserLocalAuthEntity;
import com.aibiancheng.model.bo.user.AuthenticationUserEmailBO;
import com.aibiancheng.model.bo.user.AuthenticationUserPhoneBO;
import com.aibiancheng.model.bo.user.ModifyUserPassWordBO;
import com.aibiancheng.model.resp.RespJson;

/**
 * 描述:用户基础授权service
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public interface UserLocalAuthService {

    /**
     * 根据用户名查询本地登录信息.查看是否存在
     * @param userName
     * @return
     */
    UserLocalAuthEntity findUserLocalAuthInfoByuserName(String userName) ;

    /**
     * 修改用户密码
     * @param modifyUserPassWordBO
     * @return
     */
    RespJson modifyUserPassWord(ModifyUserPassWordBO modifyUserPassWordBO) ;

    /**
     * 重置用户密码
     * @param userId
     * @return
     */
    RespJson resetUserPassWord(Long userId) ;

    /**
     * 手机号验证
     * @param authenticationUserPhoneBO
     * @return
     */
    RespJson authenticationUserPhone(AuthenticationUserPhoneBO authenticationUserPhoneBO) ;

    /**
     * 发送邮件验证码
     * @param userEmail
     * @return
     */
    RespJson authenticationSendEmail(String userEmail) ;

    /**
     * 邮箱验证
     * @param authenticationUserEmailBO
     * @return
     */
    RespJson authenticationUserEmail(AuthenticationUserEmailBO authenticationUserEmailBO);

    /**
     * 获取短信验证码.
     * @param userPhone
     * @return
     */
    RespJson authenticationSendPhone(String userPhone);
}

package com.aibiancheng.service;

import com.aibiancheng.model.bo.login.LoginBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;

/**
 * 描述:
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/22
 */
public interface UserTokenService {

    /**
     * 生成用户token
     * @param userId
     * @return
     */
    RespJsonData createToken(Long userId) ;

    /**
     * 根据用户id注销
     * @param userId
     * @return
     */
    RespJson logout(Long userId) ;
}

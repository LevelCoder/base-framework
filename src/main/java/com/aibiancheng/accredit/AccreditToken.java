package com.aibiancheng.accredit;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 描述: token对象
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/21
 */
public class AccreditToken implements AuthenticationToken {

    private String token;


    public AccreditToken(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

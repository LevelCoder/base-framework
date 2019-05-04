package com.aibiancheng.model.bo.login;

/**
 * 描述:获取验证码
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/27
 */
public class VerfityCodeBO {

    /** 登录类型 1.账户密码登录 2.手机快捷登录 3.第三方账户登录 */
    private Byte loginType;

    /** 登录名/用户名 */
    private String userName;

    public Byte getLoginType() {
        return loginType;
    }

    public void setLoginType(Byte loginType) {
        this.loginType = loginType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

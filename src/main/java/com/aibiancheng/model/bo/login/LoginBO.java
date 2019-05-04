package com.aibiancheng.model.bo.login;

/**
 * 描述:
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/27
 */
public class LoginBO {

    /** 登录名/用户名 */
    private String userName;

    /** 账户密码 如果为手机号快速登录 则不需要 */
    private String passWord;

    /** 验证码:如果为手机号快速登录则为短信验证码,否则为系统生成的验证码 */
    private String verfityCode;

    /** 登录类型 1.账户密码登录 2.手机快捷登录 3.第三方账户登录 */
    private Byte loginType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getVerfityCode() {
        return verfityCode;
    }

    public void setVerfityCode(String verfityCode) {
        this.verfityCode = verfityCode;
    }

    public Byte getLoginType() {
        return loginType;
    }

    public void setLoginType(Byte loginType) {
        this.loginType = loginType;
    }
}

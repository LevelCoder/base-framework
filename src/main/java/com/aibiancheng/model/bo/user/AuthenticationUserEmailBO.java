package com.aibiancheng.model.bo.user;

/**
 * 描述:用户邮箱认证
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/3
 */
public class AuthenticationUserEmailBO {

    /** 电子邮箱  */
    private String userEmail;

    /** 验证码 */
    private String verificationCode;

    /** 用户id */
    private Long userId;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

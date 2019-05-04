package com.aibiancheng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:用户基本授权表:例如 邮箱登录,手机号登录,账号密码登录等等
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public class UserLocalAuthEntity implements Serializable {

    /** 主键id */
    private Long id;

    /** 用户id */
    private Long userId;

    /** 用户登陆名 */
    private String loginName;

    /** 登陆密码 */
    private String passWord;

    /** 是否验证 1.已验证 2.未验证 */
    private Byte isVerified;

    /** 最后登陆时间 */
    private Date lastLoginTime;

    /** 最后登陆ip */
    private String lastLoginIp;

    /** 用户登录盐 */
    private String salt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Byte getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Byte isVerified) {
        this.isVerified = isVerified;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "UserLocalAuthEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", loginName='" + loginName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", isVerified=" + isVerified +
                ", lastLoginTime=" + lastLoginTime +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}

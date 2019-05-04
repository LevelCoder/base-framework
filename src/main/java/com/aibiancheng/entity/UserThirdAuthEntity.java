package com.aibiancheng.entity;

import java.io.Serializable;

/**
 * 描述:用户第三方授权表 例如:微信登录,QQ登录,微博登录等等
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public class UserThirdAuthEntity implements Serializable {

    /** 主键id  */
    private Long id;

    /** 用户id  */
    private Long userId;

    /** 第三方登陆id */
    private Long oauthId;

    /** 第三方登陆名 */
    private String oauthName;

    /** 认证token */
    private String oauthAccessToken;

    /** token失效时间 */
    private String oauthTokenExpires;

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

    public Long getOauthId() {
        return oauthId;
    }

    public void setOauthId(Long oauthId) {
        this.oauthId = oauthId;
    }

    public String getOauthName() {
        return oauthName;
    }

    public void setOauthName(String oauthName) {
        this.oauthName = oauthName;
    }

    public String getOauthAccessToken() {
        return oauthAccessToken;
    }

    public void setOauthAccessToken(String oauthAccessToken) {
        this.oauthAccessToken = oauthAccessToken;
    }

    public String getOauthTokenExpires() {
        return oauthTokenExpires;
    }

    public void setOauthTokenExpires(String oauthTokenExpires) {
        this.oauthTokenExpires = oauthTokenExpires;
    }

    @Override
    public String   toString() {
        return "UserThirdAuthEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", oauthId=" + oauthId +
                ", oauthName='" + oauthName + '\'' +
                ", oauthAccessToken='" + oauthAccessToken + '\'' +
                ", oauthTokenExpires='" + oauthTokenExpires + '\'' +
                '}';
    }
}

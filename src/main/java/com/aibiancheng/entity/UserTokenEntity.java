package com.aibiancheng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:用户token
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/21
 */
public class UserTokenEntity implements Serializable {

    /** 用户id */
    private Long userId;

    /** 用户token */
    private String token;

    /** 过期时间 */
    private Date expireTime;

    /** 更新时间 */
    private Date updateTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

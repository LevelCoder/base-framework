package com.aibiancheng.entity;

import java.io.Serializable;

/**
 * 描述:组织用户关联表
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public class OrganizationUserEntity implements Serializable {

    /** 组织id */
    private Long orgId;

    /** 用户id */
    private Long userId;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

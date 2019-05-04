package com.aibiancheng.entity;

import java.io.Serializable;

/**
 * 描述:组织角色关联表
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public class OrganizationRoleEntity implements Serializable {

    /** 角色id */
    private Long roleId;

    /** 组织id */
    private Long orgId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}

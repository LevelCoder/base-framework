package com.aibiancheng.entity;

import java.io.Serializable;

/**
 * 描述:资源授权表
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public class AuthResourceEntity implements Serializable{
    /** 主键id*/
    private Long id;

    /** 角色id*/
    private Long roleId;

    /** 角色类型*/
    private String roleType;

    /** 资源id*/
    private Long resourceId;

    /** 资源类型*/
    private String resourceType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    @Override
    public String toString() {
        return "AuthResourceEntity{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", roleType='" + roleType + '\'' +
                ", resourceId=" + resourceId +
                ", resourceType='" + resourceType + '\'' +
                '}';
    }
}

package com.aibiancheng.entity;

import java.io.Serializable;

/**
 * 描述:角色表
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public class RoleEntity implements Serializable {

    /** 主键id */
    private Long id;

    /** 角色名称 */
    private String roleName;

    /** 角色类型 */
    private String roleDesc;

    /** 角色状态 1.启用 2.禁用*/
    private Byte roleState;

    /** 创建人 为分级授权用 */
    private Long createUserId;

    /** 角色类型 system bussiness*/
    private String roleType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Byte getRoleState() {
        return roleState;
    }

    public void setRoleState(Byte roleState) {
        this.roleState = roleState;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", roleState=" + roleState +
                ", createUserId=" + createUserId +
                ", roleType='" + roleType + '\'' +
                '}';
    }
}

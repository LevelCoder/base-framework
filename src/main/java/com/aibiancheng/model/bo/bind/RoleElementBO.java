package com.aibiancheng.model.bo.bind;

/**
 * 描述:角色资源按钮
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/26
 */
public class RoleElementBO {
    /** 角色id */
    private Long roleId;

    /** 资源id(按钮)*/
    private Long elementId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getElementId() {
        return elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }
}

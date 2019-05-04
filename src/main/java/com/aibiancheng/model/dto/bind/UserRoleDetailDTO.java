package com.aibiancheng.model.dto.bind;

/**
 * 描述:
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/26
 */
public class UserRoleDetailDTO {

    /** 角色id */
    private Long roleId;

    /** 角色名称 */
    private String roleName;

    /** 角色选中状态 1.选中 2.为选中 用于前端checkbox判断是否选中*/
    private int roleCheckState;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleCheckState() {
        return roleCheckState;
    }

    public void setRoleCheckState(int roleCheckState) {
        this.roleCheckState = roleCheckState;
    }
}

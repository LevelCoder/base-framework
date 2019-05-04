package com.aibiancheng.model.bo.bind;

/**
 * 描述:角色菜单
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/26
 */
public class RoleMenuBO {

    /** 角色id */
    private Long roleId;

    /** 菜单id 数组 由于 都属于菜单类型 不需要区分是目录还是菜单 统一归纳为菜单 即可*/
    private Long[] menuIds;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(Long[] menuIds) {
        this.menuIds = menuIds;
    }
}

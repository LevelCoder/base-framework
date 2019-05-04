package com.aibiancheng.model.bo.role;

/**
 * 描述:
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/26
 */
public class FindRoleBO {

    /** 角色状态 1.启用 2.禁用 */
    private Byte roleState;

    /** 角色名称 */
    private String roleName;

    /** 初始页 默认为1 */
    private Integer currentPage;

    /** 每页条数 默认为 10 */
    private Integer pageSize;

    public Byte getRoleState() {
        return roleState;
    }

    public void setRoleState(Byte roleState) {
        this.roleState = roleState;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

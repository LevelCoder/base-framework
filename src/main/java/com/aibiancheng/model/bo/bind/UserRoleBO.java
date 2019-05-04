package com.aibiancheng.model.bo.bind;

import java.util.List;

/**
 * 描述:用户角色绑定
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/26
 */
public class UserRoleBO {

    /** 用户id*/
    private Long userId;

    /** 角色id 列表 */
    private List<Long> roleIds;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
}

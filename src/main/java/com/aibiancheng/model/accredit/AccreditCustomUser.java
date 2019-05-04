package com.aibiancheng.model.accredit;

import java.util.List;

/**
 * 描述:自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息,可以不断追加内容
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/27
 */
public class AccreditCustomUser {

    /** 用户id */
    private Long userId;

    /** 用户昵称 */
    private String nickName;

    /** 用户状态 */
    private Byte userState;

    /** 角色集合 包含角色id,角色名称 */
    private List<AccreditRole> accreditRoleList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<AccreditRole> getAccreditRoleList() {
        return accreditRoleList;
    }

    public void setAccreditRoleList(List<AccreditRole> accreditRoleList) {
        this.accreditRoleList = accreditRoleList;
    }

    public Byte getUserState() {
        return userState;
    }

    public void setUserState(Byte userState) {
        this.userState = userState;
    }
}

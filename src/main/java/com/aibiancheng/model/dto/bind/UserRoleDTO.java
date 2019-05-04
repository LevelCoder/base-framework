package com.aibiancheng.model.dto.bind;

import java.util.List;

/**
 * 描述:
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/26
 */
public class UserRoleDTO {

    /** 用户id */
    private Long userId;

    /** 用户名 */
    private String userName;

    private List<UserRoleDetailDTO> userRoleDetailDTOList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserRoleDetailDTO> getUserRoleDetailDTOList() {
        return userRoleDetailDTOList;
    }

    public void setUserRoleDetailDTOList(List<UserRoleDetailDTO> userRoleDetailDTOList) {
        this.userRoleDetailDTOList = userRoleDetailDTOList;
    }
}

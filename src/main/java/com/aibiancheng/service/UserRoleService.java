package com.aibiancheng.service;

import com.aibiancheng.model.bo.bind.UserRoleBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;

/**
 * 描述:
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/26
 */
public interface UserRoleService {

    /**
     * 根据用户id 查询所有角色信息
     * @param userId
     * @return
     */
    RespJsonData findUserRole(Long userId) ;

    /**
     * 对用户进行角色绑定
     * @param userRoleBO
     * @return
     */
    RespJson bindUserRole(UserRoleBO userRoleBO);
}

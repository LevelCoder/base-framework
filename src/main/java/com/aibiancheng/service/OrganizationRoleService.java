package com.aibiancheng.service;

import com.aibiancheng.model.resp.RespJsonData;

/**
 * 描述:
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/23
 */
public interface OrganizationRoleService {

    /**
     * 查看组织角色列表
     * @param organizationId
     * @return
     */
    RespJsonData findOrganizationRole(Long organizationId);
}

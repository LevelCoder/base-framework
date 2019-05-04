package com.aibiancheng.service;

import com.aibiancheng.model.bo.organization.AddOrganizationBO;
import com.aibiancheng.model.resp.RespJson;

/**
 * 描述:组织架构service
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public interface OrganizationService {

    /**
     * 新增组织
     * @param addOrganizationBO
     * @return
     */
    RespJson addOrganization(AddOrganizationBO addOrganizationBO);
}

package com.aibiancheng.service.impl;

import com.aibiancheng.mapper.OrganizationRoleMapper;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.service.OrganizationRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/23
 */
@Service("organizationRoleService")
public class OrganizationRoleServiceImpl implements OrganizationRoleService {

    private static Logger logger = LoggerFactory.getLogger(OrganizationRoleServiceImpl.class);

    @Autowired
    private OrganizationRoleMapper organizationRoleMapper;


    @Override
    public RespJsonData findOrganizationRole(Long organizationId) {
        return null;
    }
}

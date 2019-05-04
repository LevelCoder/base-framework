package com.aibiancheng.service;

import com.aibiancheng.model.bo.role.AddRoleBO;
import com.aibiancheng.model.bo.role.EditRoleBO;
import com.aibiancheng.model.bo.role.FindRoleBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.resp.RespJsonPageData;

/**
 * 描述:角色service
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public interface RoleService {

    /**
     * 新增角色
     * @param addRoleBO
     * @return
     */
    RespJson addRole(AddRoleBO addRoleBO,Long userId) ;

    /**
     * 修改角色信息
     * @param editRoleBO
     * @return
     */
    RespJson eidtRole(EditRoleBO editRoleBO,Long userId) ;

    /**
     * 删除角色信息
     * @param roleId
     * @return
     */
    RespJson deleteRole(Long roleId) ;

    /**
     * 查看角色详情
     * @param roleId
     * @return
     */
    RespJsonData viewRoleDetail(Long roleId) ;

    /**
     * 查看角色列表
     * @param findRoleBO
     * @return
     */
    RespJsonPageData viewRoleList(FindRoleBO findRoleBO,Long userId) ;

    /**
     * 修改角色状态
     * @param roleId
     * @param roleState
     * @return
     */
    RespJson changeRoleState(Long roleId, byte roleState) ;
}

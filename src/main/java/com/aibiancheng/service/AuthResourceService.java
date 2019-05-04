package com.aibiancheng.service;

import com.aibiancheng.model.bo.bind.RoleElementBO;
import com.aibiancheng.model.bo.bind.RoleMenuBO;
import com.aibiancheng.model.bo.bind.RoleResourceElementBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;

/**
 * 描述:资源授权service
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public interface AuthResourceService {

    /**
     * 根据角色id查询绑定菜单信息
     * @param roleId
     * @return
     */
    RespJsonData findRoleResourceMenu(Long roleId) ;

    /**
     * 根据角色信息绑定用户菜单权限信息
     * @param roleMenuBO
     * @return
     */
    RespJson bindRoleResourceMenu(RoleMenuBO roleMenuBO) ;

    /**
     * 获取角色资源(按钮)
     * @param roleResourceElementBO
     * @return
     */
    RespJsonData findRoleResourceElement(RoleResourceElementBO roleResourceElementBO) ;

    /**
     *绑定用户资源(按钮) 权限 传递参数 roleId,resourceId 及时绑定,不统一点击时候绑定,可一次性绑定多个资源信息
     * @param roleElementBO
     * @return
     */
    RespJson bindRoleResourceElement(RoleElementBO roleElementBO) ;

    /**
     * 移除角色资源(按钮) 权限 传递参数 roleId ,resourceId 及时移除,不统一点击保存时进行绑定操作
     * @param roleElementBO
     * @return
     */
    RespJson removeRoleResourceElement(RoleElementBO roleElementBO) ;
}

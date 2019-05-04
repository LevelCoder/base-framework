package com.aibiancheng.controller;

import com.aibiancheng.aop.log.LogAnnotation;
import com.aibiancheng.aop.log.LogEnum;
import com.aibiancheng.model.bo.bind.RoleElementBO;
import com.aibiancheng.model.bo.bind.RoleMenuBO;
import com.aibiancheng.model.bo.bind.RoleResourceElementBO;
import com.aibiancheng.model.bo.bind.UserRoleBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.service.AuthResourceService;
import com.aibiancheng.service.OrganizationRoleService;
import com.aibiancheng.service.UserRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:绑定相关操作
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/26
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/server/bind")
public class BindController extends AbstractController {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private AuthResourceService authResourceService;

    @Autowired
    private OrganizationRoleService organizationRoleService;


    /**
     * 用户角色相关:用户角色查看
     */
    @LogAnnotation(module = "用户绑定" ,method = LogEnum.SELECT ,logDesc = "查看用户角色列表")
    @RequiresPermissions("sys:find:user-role")
    @RequestMapping(value = "/findUserRole" ,method = RequestMethod.GET)
    public RespJsonData findUserRole(Long userId) {
        return userRoleService.findUserRole(userId);
    }

    /**
     * 用户角色相关:用户角色绑定
     * @return
     */
    @LogAnnotation(module = "用户绑定" ,method = LogEnum.UPDATE ,logDesc = "绑定用户角色列表")
    @RequiresPermissions("sys:bind:user-role")
    @RequestMapping(value = "/bindUserRole",method = RequestMethod.POST)
    public RespJson bindUserRole(@RequestBody UserRoleBO userRoleBO){
        return userRoleService.bindUserRole(userRoleBO);
    }


    /**
     * 角色资源(菜单)相关:角色资源查看
     * @return
     */
    @LogAnnotation(module = "资源绑定" ,method = LogEnum.UPDATE ,logDesc = "查看角色菜单列表")
    @RequiresPermissions("sys:find:role-menu")
    @RequestMapping(value = "/findRoleResourceMenu",method = RequestMethod.GET)
    public RespJsonData findRoleResourceMenu( Long roleId) throws Exception {
        return authResourceService.findRoleResourceMenu(roleId);
    }

    /**
     * 角色资源(菜单)相关:角色资源绑定
     * 点击保存时候才会对菜单进行更新,不做单独保存操作,对于按钮级别的做及时保存 都存放在 AuthResource 下
     * @return
     */
    @LogAnnotation(module = "资源绑定" ,method = LogEnum.UPDATE ,logDesc = "绑定角色菜单列表")
    @RequiresPermissions("sys:bind:role-menu")
    @RequestMapping(value = "/bindRoleResourceMenu",method = RequestMethod.POST)
    public RespJson bindRoleResourceMenu(@RequestBody RoleMenuBO roleMenuBO) throws Exception {
        return authResourceService.bindRoleResourceMenu(roleMenuBO);
    }

    /**
     * 角色资源(按钮)相关:角色资源查看
     * 根据 roleId,resourceId 确定用户拥有哪些按钮权限
     * 根据 menuId查看当前菜单下拥有哪些按钮 随时查询
     */
    @LogAnnotation(module = "资源绑定" ,method = LogEnum.UPDATE ,logDesc = "查看角色按钮列表")
    @RequiresPermissions("sys:find:role-element")
    @RequestMapping(value = "/findRoleResourceElement",method = RequestMethod.GET)
    public RespJsonData findRoleResourceElement( RoleResourceElementBO roleResourceElementBO) {
        return authResourceService.findRoleResourceElement(roleResourceElementBO);
    }

    /**
     * 角色资源(按钮)相关:角色资源绑定
     * @return
     */
    @LogAnnotation(module = "资源绑定" ,method = LogEnum.UPDATE ,logDesc = "绑定角色按钮")
    @RequiresPermissions("sys:bind:role-element")
    @RequestMapping(value = "/bindRoleResourceElement" ,method = RequestMethod.POST)
    public RespJson bindRoleResourceElement(@RequestBody RoleElementBO roleElementBO) {
        return authResourceService.bindRoleResourceElement(roleElementBO);
    }

    /**
     * 角色资源(按钮)相关:角色资源移除
     * @return
     */
    @LogAnnotation(module = "资源绑定" ,method = LogEnum.UPDATE ,logDesc = "移除角色按钮")
    @RequiresPermissions("sys:remove:role-element")
    @RequestMapping(value = "/removeRoleResourceElement",method= RequestMethod.POST)
    public RespJson removeRoleResourceElement(@RequestBody RoleElementBO roleElementBO)  {
        return authResourceService.removeRoleResourceElement(roleElementBO);
    }


    /**
     * 组织用户相关:查看组织用户列表
     * @return
     */
    @LogAnnotation(module = "资源绑定" ,method = LogEnum.SELECT ,logDesc = "查看组织用户列表")
    @RequiresPermissions("sys:find:org-user")
    @RequestMapping(value = "/findOrganizationUser",method= RequestMethod.GET)
    public RespJsonData findOrganizationUser(){
        return null;
    }

    /**
     * 组织用户相关:绑定组织用户
     * @return
     */
    @LogAnnotation(module = "资源绑定" ,method = LogEnum.UPDATE ,logDesc = "绑定组织用户")
    @RequiresPermissions("sys:bind:org-user")
    @RequestMapping(value = "/bindOrganiztaionUser",method= RequestMethod.POST)
    public RespJson bindOrganiztaionUser(){
        return null;
    }

    /**
     * 组织用户相关:移除组织用户
     * @return
     */
    @LogAnnotation(module = "资源绑定" ,method = LogEnum.UPDATE ,logDesc = "移除组织用户")
    @RequiresPermissions("sys:remove:org-user")
    @RequestMapping(value = "/removeOrganizationUser",method= RequestMethod.POST)
    public RespJson removeOrganizationUser(){
        return null;
    }


    /**
     * 组织角色相关:查看组织角色列表
     * @return
     */
    @LogAnnotation(module = "资源绑定" ,method = LogEnum.SELECT ,logDesc = "查看组织角色列表")
    @RequiresPermissions("sys:find:org-role")
    @RequestMapping(value = "/findOrganizationRole",method= RequestMethod.GET)
    public RespJsonData findOrganizationRole(Long organizationId){
        return organizationRoleService.findOrganizationRole(organizationId);
    }

    /**
     * 组织角色相关:绑定组织角色
     * @return
     */
    @LogAnnotation(module = "资源绑定" ,method = LogEnum.UPDATE ,logDesc = "绑定组织角色")
    @RequiresPermissions("sys:bind:org-role")
    @RequestMapping(value = "/bindOrganizationRole",method= RequestMethod.POST)
    public RespJson bindOrganizationRole(){
        return null;
    }

    /**
     * 组织角色相关:移除组织角色
     * @return
     */
    @LogAnnotation(module = "资源绑定" ,method = LogEnum.UPDATE ,logDesc = "移除组织角色")
    @RequiresPermissions("sys:remove:org-role")
    @RequestMapping(value = "/removeOrganizationRole",method= RequestMethod.POST)
    public RespJson removeOrganizationRole(){
        return null;
    }
}

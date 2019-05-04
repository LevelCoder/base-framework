package com.aibiancheng.controller;

import com.aibiancheng.aop.log.LogAnnotation;
import com.aibiancheng.aop.log.LogEnum;
import com.aibiancheng.model.bo.role.AddRoleBO;
import com.aibiancheng.model.bo.role.EditRoleBO;
import com.aibiancheng.model.bo.role.FindRoleBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.resp.RespJsonPageData;
import com.aibiancheng.service.RoleService;
import com.aibiancheng.utils.BaseAuthConstant;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:角色管理控制层
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/server/role")
public class RoleController extends AbstractController {

    @Autowired
    private RoleService roleService;

    /**
     * 新增角色
     * @return
     */
    @LogAnnotation(module = "角色管理" ,method = LogEnum.ADD ,logDesc = "新增角色")
    @RequiresPermissions("sys:role:add")
    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    public RespJson addRole(@RequestBody AddRoleBO addRoleBO) {
        return roleService.addRole(addRoleBO,getUserId());
    }


    /**
     * 修改角色信息
     * @return
     */
    @LogAnnotation(module = "角色管理" ,method = LogEnum.UPDATE ,logDesc = "修改角色")
    @RequiresPermissions("sys:role:edit")
    @RequestMapping(value = "/eidtRole",method = RequestMethod.POST)
    public RespJson eidtRole(@RequestBody EditRoleBO editRoleBO)  {
       return roleService.eidtRole(editRoleBO,getUserId());
    }


    /**
     * 删除角色信息
     * @return
     */
    @LogAnnotation(module = "角色管理" ,method = LogEnum.DEL ,logDesc = "删除角色")
    @RequiresPermissions("sys:role:delete")
    @RequestMapping(value = "/deleteRole",method = RequestMethod.POST)
    public RespJson deleteRole(@RequestBody Long roleId)  {
        return roleService.deleteRole(roleId);
    }

    /**
     * 查看角色详情
     * @return
     */
    @LogAnnotation(module = "角色管理" ,method = LogEnum.SELECT ,logDesc = "查看角色详情")
    @RequiresPermissions("sys:role:detail")
    @RequestMapping(value = "/viewRoleDetail",method = RequestMethod.GET)
    public RespJsonData viewRoleDetail( Long roleId) {
        return roleService.viewRoleDetail(roleId);
    }


    /**
     * 查看角色列表
     * @return
     */
    @LogAnnotation(module = "角色管理" ,method = LogEnum.SELECT ,logDesc = "查看角色列表")
    @RequiresPermissions("sys:role:list")
    @RequestMapping(value = "/viewRoleList",method = RequestMethod.GET)
    public RespJsonPageData viewRoleList( FindRoleBO findRoleBO) {
        return roleService.viewRoleList(findRoleBO,getUserId());
    }


    /**
     * 启用角色
     * @param roleId
     * @return
     */
    @LogAnnotation(module = "角色管理" ,method = LogEnum.UPDATE ,logDesc = "启用角色")
    @RequiresPermissions("sys:role:open")
    @RequestMapping(value = "/openRole" ,method = RequestMethod.POST)
    public RespJson openRole(@RequestBody Long roleId)  {
        return roleService.changeRoleState(roleId,(byte)1);
    }

    /**
     * 禁用角色
     * @param roleId
     * @return
     * @throws Exception
     */
    @LogAnnotation(module = "角色管理" ,method = LogEnum.UPDATE ,logDesc = "禁用角色")
    @RequiresPermissions("sys:role:close")
    @RequestMapping(value = "/closeRole" ,method = RequestMethod.POST)
    public RespJson closeRole(@RequestBody Long roleId) {
        return roleService.changeRoleState(roleId,(byte)2);
    }

}

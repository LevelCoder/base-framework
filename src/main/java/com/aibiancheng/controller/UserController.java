package com.aibiancheng.controller;

import com.aibiancheng.aop.log.LogAnnotation;
import com.aibiancheng.aop.log.LogEnum;
import com.aibiancheng.entity.UserEntity;
import com.aibiancheng.model.bo.user.AddUserBO;
import com.aibiancheng.model.bo.user.BackUserPassWordBO;
import com.aibiancheng.model.bo.user.EditUserBO;
import com.aibiancheng.model.bo.user.FindUserListBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.resp.RespJsonPageData;
import com.aibiancheng.service.UserService;
import com.aibiancheng.utils.BaseAuthConstant;
import com.aibiancheng.utils.business.ConverUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 描述:用户管理控制层
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/server/user")
public class UserController extends AbstractController{

    @Autowired
    private UserService userService;



    /**
     * 所有用户列表
     * 1.如果当前登录人员为超级管理员则拥有最大权限
     * 2.如果为区域管理员则只拥有自己区域权限
     * 3.如果拥有被授权角色,则拥有被授权角色权限
     * 4.如果不是以上3点则只能查看自己的信息
     */
    @LogAnnotation(module = "用户管理" ,method = LogEnum.SELECT ,logDesc = "查看用户列表")
    @RequiresPermissions("sys:user:list")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public RespJsonPageData viewUserList(FindUserListBO findUserListBO)  {
        return userService.viewUserList(findUserListBO);
    }

    /**
     * 查看用户详情
     * @return
     */
    @LogAnnotation(module = "用户管理" ,method = LogEnum.SELECT ,logDesc = "查看用户详情")
    @RequiresPermissions("sys:user:detail")
    @RequestMapping(value = "/viewUserDetail",method = RequestMethod.GET)
    public RespJsonData viewUserDetail(Long userId)  {
        return userService.viewUserDetail(userId);
    }

    /**
     * 新增用户
     * @return
     */
    @LogAnnotation(module = "用户管理" ,method = LogEnum.ADD ,logDesc = "新增用户")
    @RequiresPermissions("sys:user:add")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public RespJson addUser(@RequestBody AddUserBO addUserBO) {

        return userService.addUser(addUserBO);
    }

    /**
     * 修改用户
     * @return
     */
    @LogAnnotation(module = "用户管理" ,method = LogEnum.UPDATE ,logDesc = "修改用户")
    @RequiresPermissions("sys:user:edit")
    @RequestMapping(value = "/editUser",method = RequestMethod.POST)
    public RespJson editUser(@RequestBody EditUserBO editUserBO)  {
        if(editUserBO.getId() == getUserId()){
            return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,"不能修改超级管理员用户");
        }
        return userService.editUser(editUserBO);
    }

    /**
     * 删除用户
     * @return
     */
    @LogAnnotation(module = "用户管理" ,method = LogEnum.DEL ,logDesc = "删除用户")
    @RequiresPermissions("sys:user:delete")
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public RespJson deleteUser(@RequestBody Long userId)  {
        if(userId == getUserId()){
           return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,"不能删除自己");
        }
        return userService.deleteUser(userId);
    }


    /**
     * 启用用户
     * @return
     */
    @LogAnnotation(module = "用户管理" ,method = LogEnum.UPDATE ,logDesc = "启用用户")
    @RequiresPermissions("sys:user:open")
    @RequestMapping(value = "/openUser",method = RequestMethod.POST)
    public RespJson openUser(@RequestBody Long userId) {
        if(userId == getUserId()){
            return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,"不能启用自己");
        }
        return userService.changeUserState(userId,(byte)1);
    }

    /**
     * 禁用用户
     * @return
     */
    @LogAnnotation(module = "用户管理" ,method = LogEnum.UPDATE ,logDesc = "禁用用户")
    @RequiresPermissions("sys:user:close")
    @RequestMapping(value = "/closeUser",method = RequestMethod.POST)
    public RespJson closeUser(@RequestBody Long userId)  {
        if(userId == getUserId()){
            return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,"不能禁用自己");
        }
        return userService.changeUserState(userId,(byte)2);
    }


    /**
     * 重置用户密码
     * @return
     */
    @LogAnnotation(module = "用户管理" ,method = LogEnum.UPDATE ,logDesc = "重置用户密码")
    @RequiresPermissions("sys:user:reset")
    @RequestMapping(value = "/resetPassWord",method = RequestMethod.POST)
    public RespJson resetPassWord(@RequestBody Long userId)  {
        return userService.resetPassWord(userId);
    }

    /**
     * 用户密码找回/忘记密码
     * @return
     */
    @RequestMapping(value = "/backUserPassWord",method = RequestMethod.POST)
    public RespJson backUserPassWord(@RequestBody BackUserPassWordBO backUserPassWordBO)  {
        return userService.backUserPassWord(backUserPassWordBO);
    }


}

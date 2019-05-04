package com.aibiancheng.controller;

import com.aibiancheng.aop.log.LogAnnotation;
import com.aibiancheng.aop.log.LogEnum;
import com.aibiancheng.model.bo.user.AuthenticationUserEmailBO;
import com.aibiancheng.model.bo.user.AuthenticationUserPhoneBO;
import com.aibiancheng.model.bo.user.ModifyUserPassWordBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.service.UserLocalAuthService;
import com.aibiancheng.service.UserService;
import com.aibiancheng.service.UserThirdAuthService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:个人信息
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/2
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/server/user/profile")
public class ProfileController extends AbstractController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserLocalAuthService userLocalAuthService;

    @Autowired
    private UserThirdAuthService userThirdAuthService;

    /**
     * 个人信息
     * @return
     */
    @LogAnnotation(module = "个人资料" ,method = LogEnum.SELECT ,logDesc = "查看个人信息")
    @RequestMapping(value = "/profileInfo")
    public RespJsonData profileInfo(){
        return null;
    }



    /**
     * 用户密码重置
     * @return
     */
    @LogAnnotation(module = "个人资料" ,method = LogEnum.ATHOR ,logDesc = "重置密码")
    @RequestMapping(value = "/resetUserPassWord",method = RequestMethod.POST)
    public RespJson resetUserPassWord(@RequestBody Long userId)  {
        return userLocalAuthService.resetUserPassWord(userId);
    }

    /**
     * 用户密码修改
     * @return
     */
    @LogAnnotation(module = "个人资料" ,method = LogEnum.ATHOR ,logDesc = "修改密码")
    @RequestMapping(value = "/modifyUserPassWord" ,method = RequestMethod.POST)
    public RespJson modifyUserPassWord(@RequestBody ModifyUserPassWordBO modifyUserPassWordBO)  {
        return userLocalAuthService.modifyUserPassWord(modifyUserPassWordBO);
    }


    /**
     * 用户邮箱认证
     * @return
     */
    @LogAnnotation(module = "个人资料" ,method = LogEnum.ATHOR ,logDesc = "邮箱认证")
    @RequestMapping(value = "/authenticationUserEmail" ,method = RequestMethod.POST)
    public RespJson authenticationUserEmail(@RequestBody AuthenticationUserEmailBO authenticationUserEmailBO){
        return userLocalAuthService.authenticationUserEmail(authenticationUserEmailBO);
    }

    /**
     * 用户邮箱认证-发送验证码到邮件
     * @return
     */
    @LogAnnotation(module = "个人资料" ,method = LogEnum.ATHOR ,logDesc = "邮箱认证")
    @RequestMapping(value = "/authenticationSendEmail",method = RequestMethod.POST)
    public RespJson authenticationSendEmail(@RequestBody String userEmail){
        return userLocalAuthService.authenticationSendEmail(userEmail);
    }


    /**
     * 用户手机认证
     * @return
     */
    @LogAnnotation(module = "个人资料" ,method = LogEnum.ATHOR ,logDesc = "手机认证")
    @RequestMapping(value = "/authenticationUserPhone" ,method = RequestMethod.POST)
    public RespJson authenticationUserPhone(@RequestBody AuthenticationUserPhoneBO authenticationUserPhoneBO)  {
        return userLocalAuthService.authenticationUserPhone(authenticationUserPhoneBO);
    }


    /**
     * 用户手机号认证-发送验证码到手机
     * @return
     */
    @LogAnnotation(module = "个人资料" ,method = LogEnum.ATHOR ,logDesc = "手机认证")
    @RequestMapping(value = "/authenticationSendPhone",method = RequestMethod.POST)
    public RespJson authenticationSendPhone(@RequestBody String userPhone){
        return userLocalAuthService.authenticationSendPhone(userPhone);
    }


    /**
     * 修改头像:头像图片存储地址采用第三方存储/自定义fastdfs存储
     * @return
     */
    @RequestMapping(value = "/modifyUserPhoto",method = RequestMethod.POST)
    public RespJson modifyUserPhoto(){
        return null;
    }

    /**
     * 变更手机号:原先所绑定的手机号将被取消.
     * @return
     */
    @LogAnnotation(module = "个人资料" ,method = LogEnum.ATHOR ,logDesc = "变更手机号")
    @RequestMapping(value = "/modifyUserPhone",method = RequestMethod.POST)
    public RespJson modifyUserPhone(){
        return null;
    }


    /**
     * 变更邮箱
     * @return
     */
    @LogAnnotation(module = "个人资料" ,method = LogEnum.ATHOR ,logDesc = "变更邮箱")
    @RequestMapping(value = "/modifyUserEmail",method = RequestMethod.POST)
    public RespJson modifyUserEmail(){
        return null;
    }
}

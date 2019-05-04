package com.aibiancheng.controller;

import com.aibiancheng.aop.log.LogAnnotation;
import com.aibiancheng.aop.log.LogEnum;
import com.aibiancheng.entity.UserEntity;
import com.aibiancheng.entity.UserLocalAuthEntity;
import com.aibiancheng.model.bo.login.LoginBO;
import com.aibiancheng.model.bo.login.VerfityCodeBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.service.UserLocalAuthService;
import com.aibiancheng.service.UserService;
import com.aibiancheng.service.UserTokenService;
import com.aibiancheng.utils.BaseAuthConstant;
import com.aibiancheng.utils.basic.ObjectUtil;
import com.aibiancheng.utils.basic.RegularUtil;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:登录控制层
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/21
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/")
public class LogingController extends AbstractController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserTokenService userTokenService;

    @Autowired
    private UserLocalAuthService userLocalAuthService;



    /**
     * 用户登录(账号密码登录) 登录返回token信息,在根据token信息 请求网站首页
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public RespJsonData login(@RequestBody LoginBO loginBO)  {
        if(ObjectUtil.isNotEmpty(loginBO)){
            Object userId = null;
            if(loginBO.getLoginType() == 1){//账号密码登录
                //根据用户名密码获取当前用户账户信息.
                UserLocalAuthEntity userLocalAuthEntity = userLocalAuthService.findUserLocalAuthInfoByuserName(loginBO.getUserName());
                //验证用户名密码是否正确
                if(ObjectUtil.isEmpty(userLocalAuthEntity) || !userLocalAuthEntity.getPassWord().equals(new Sha256Hash(loginBO.getPassWord()+loginBO.getUserName(),userLocalAuthEntity.getSalt()).toHex())){
                    return new RespJsonData(null,BaseAuthConstant.responseCode.FAIL_CODE,BaseAuthConstant.responseUserMessage.USERNAME_OR_PASSWORD_FAIL);
                }
                //验证用户锁定状态
                if(userService.findUserStateByUserId(userLocalAuthEntity.getUserId()) == 0){
                    return new RespJsonData(null,BaseAuthConstant.responseCode.FAIL_CODE,BaseAuthConstant.responseUserMessage.ACCOUNT_IS_LOCKED);
                }
                userId = userLocalAuthEntity.getUserId();
            }else if(loginBO.getLoginType() == 2){//手机快捷登录
                if(RegularUtil.isMobile(loginBO.getUserName())){
                    if(ObjectUtil.isNotEmpty(loginBO.getVerfityCode())){
                        //验证验证码是否正确
                        //验证通过后通过查询手机号.获取用户信息
                        UserEntity userEntity = userService.findUserInfoByUserPhone(loginBO.getUserName());
                        if(ObjectUtil.isNotEmpty(userEntity)){
                            if(userEntity.getUserState() == 0){
                                return new RespJsonData(null,BaseAuthConstant.responseCode.FAIL_CODE,BaseAuthConstant.responseUserMessage.ACCOUNT_IS_LOCKED);
                            }
                            userId = userEntity.getId();
                        }else{
                            return new RespJsonData(null,BaseAuthConstant.responseCode.FAIL_CODE,BaseAuthConstant.responseUserMessage.USER_DOES_NOT_EXIST);
                        }
                    }else{
                        return new RespJsonData(null,BaseAuthConstant.responseCode.FAIL_CODE,BaseAuthConstant.responseMessage.PARAMS_IS_EMPTY);
                    }
                }else{
                    return new RespJsonData(null,BaseAuthConstant.responseCode.FAIL_CODE,BaseAuthConstant.responseUserMessage.PHONE_IS_FAIL);
                }
            }
            return userTokenService.createToken(Long.valueOf(userId.toString()));
        }else{
            return new RespJsonData(null,BaseAuthConstant.responseCode.FAIL_CODE,BaseAuthConstant.responseMessage.PARAMS_IS_EMPTY);
        }
    }


    /**
     * 获取验证码 存入redis 中 不包含第三方登录.第三方登录不需要获取验证码
     * @return
     */
    @RequestMapping(value = "/getverfityCode" ,method = RequestMethod.GET)
    public RespJsonData getverfityCode(@RequestBody VerfityCodeBO verfityCodeBO){
        //如果为短信登录
        if(verfityCodeBO.getLoginType() == 2){

        }else{

        }
        return null;
    }


    /**
     * 注销登录
     * @return
     */
    @RequestMapping(value = "/layout" ,method = RequestMethod.POST)
    public RespJson layout() throws Exception {
        return userTokenService.logout(getUserId());
    }



}

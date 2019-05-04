package com.aibiancheng.service.impl;

import com.aibiancheng.entity.AuthResourceEntity;
import com.aibiancheng.entity.MenuEntity;
import com.aibiancheng.entity.UserLocalAuthEntity;
import com.aibiancheng.exception.CustomException;
import com.aibiancheng.mapper.UserLocalAuthMapper;
import com.aibiancheng.model.bo.user.AuthenticationUserEmailBO;
import com.aibiancheng.model.bo.user.AuthenticationUserPhoneBO;
import com.aibiancheng.model.bo.user.ModifyUserPassWordBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.service.UserLocalAuthService;
import com.aibiancheng.utils.BaseAuthConstant;
import com.aibiancheng.utils.basic.ObjectUtil;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:用户基础授权业务实现层
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
@Service("userLocalAuthService")
public class UserLocalAuthServiceImpl implements UserLocalAuthService {

    private static Logger logger = LoggerFactory.getLogger(UserLocalAuthServiceImpl.class);

    @Autowired
    private UserLocalAuthMapper userLocalAuthMapper;

    /** 引入密码注解:系统新增用户,或者重制账户密码时候使用 */
    @Value("${password.default}")
    private String defaultPassWord;

    @Override
    public UserLocalAuthEntity findUserLocalAuthInfoByuserName(String userName)  {
        try{
            logger.info("start find user local auth info by user name");
            logger.info("transfer parameters >> userName:{}", userName);

            UserLocalAuthEntity userLocalAuthEntity = userLocalAuthMapper.findUserLocalAuthInfoByuserName(userName);

            logger.info("return parameter >> userLocalAuthEntity:{}", JSON.toJSON(userLocalAuthEntity));
            logger.info("end find user local auth info by user name");
            return userLocalAuthEntity;
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson modifyUserPassWord(ModifyUserPassWordBO modifyUserPassWordBO)  {
        try{
            logger.info("start modify user pass word");
            logger.info("transfer parameters >> userId:{}", JSON.toJSON(modifyUserPassWordBO));

            List<UserLocalAuthEntity> userLocalAuthEntities = userLocalAuthMapper.findUserLocalAuthListByUserId(modifyUserPassWordBO.getUserId());
            if(ObjectUtil.isNotEmpty(userLocalAuthEntities)){
                List<UserLocalAuthEntity> userLocalAuthEntityList = new ArrayList<UserLocalAuthEntity>();
                for(UserLocalAuthEntity userLocalAuth:userLocalAuthEntities){
                    if(userLocalAuth.getPassWord().equals(new Sha256Hash(modifyUserPassWordBO.getNewPassWord()+userLocalAuth.getLoginName(),userLocalAuth.getSalt()).toHex())){
                        return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,BaseAuthConstant.responseUserMessage.PASS_WORD_IS_IDENTICAL);
                    }
                    userLocalAuth.setPassWord(new Sha256Hash(modifyUserPassWordBO.getNewPassWord()+userLocalAuth.getLoginName(),userLocalAuth.getSalt()).toHex());
                    userLocalAuthEntityList.add(userLocalAuth);
                }
                userLocalAuthMapper.updateBatchByEntity(userLocalAuthEntityList);
            }
            logger.info("end modify user pass word");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson resetUserPassWord(Long userId) {
        try{
            logger.info("start reset user pass word");
            logger.info("transfer parameters >> userId:{}", userId);

            List<UserLocalAuthEntity> userLocalAuthEntities = userLocalAuthMapper.findUserLocalAuthListByUserId(userId);
            if(ObjectUtil.isNotEmpty(userLocalAuthEntities)){
                List<UserLocalAuthEntity> userLocalAuthEntityList = new ArrayList<UserLocalAuthEntity>();
                for(UserLocalAuthEntity userLocalAuth:userLocalAuthEntities){
                    userLocalAuth.setPassWord(new Sha256Hash(defaultPassWord+userLocalAuth.getLoginName(),userLocalAuth.getSalt()).toHex());
                    userLocalAuthEntityList.add(userLocalAuth);
                }
                userLocalAuthMapper.updateBatchByEntity(userLocalAuthEntityList);
            }
            logger.info("end reset user pass word");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson authenticationUserPhone(AuthenticationUserPhoneBO authenticationUserPhoneBO)  {
        //1.生成验证码
        //2.验证码保存到redis缓存中   key-value : userPhone:18701346478,verificationCode:randomCode {18701346478,1001}
        //3.调用sms短信接口为手机进行短信发送
        //4.接收短信发送回调信息返回结果
        try{
            UserLocalAuthEntity userLocalAuthEntity = userLocalAuthMapper.findUserLocalAuthInfoByMap(authenticationUserPhoneBO.getUserId(),authenticationUserPhoneBO.getUserPhone());

            return null;
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }


    @Override
    public RespJson authenticationUserEmail(AuthenticationUserEmailBO authenticationUserEmailBO) {
        //1.根据手机号获取缓存中所存储验证码信息
        //2.验证前端录入的验证码和缓存中所存储的是否一致
        //3.一致更新用户认证信息.不一致返回验证码错误,请重新获取
        return null;
    }

    @Override
    public RespJson authenticationSendPhone(String userPhone) {
        return null;
    }



    @Override
    public RespJson authenticationSendEmail(String userEmail) {
        try{
            logger.info("start email authentication send verfity code ");
            logger.info("transfer parameters >> userEmail:{}", userEmail);



            logger.info("end  email authentication send verfity code ");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

}

package com.aibiancheng.service.impl;

import com.aibiancheng.accredit.AccreditToken;
import com.aibiancheng.accredit.AccreditTokenGenerator;
import com.aibiancheng.entity.UserTokenEntity;
import com.aibiancheng.exception.CustomException;
import com.aibiancheng.mapper.UserTokenMapper;
import com.aibiancheng.model.bo.login.LoginBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.service.UserTokenService;
import com.aibiancheng.utils.BaseAuthConstant;
import com.aibiancheng.utils.basic.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 描述:
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/22
 */
@Service("userTokenService")
public class UserTokenServiceImpl implements UserTokenService {

    /** 引入日志  */
    private static Logger logger = LoggerFactory.getLogger(UserTokenServiceImpl.class);

    /** 设置token 过期时间 和session 时间一样 暂定为 半个小时  */
    private static final int EXPIRE_TIME = 1800 ;

    @Autowired
    private UserTokenMapper userTokenMapper;

    @Override
    public RespJsonData createToken(Long  userId)  {
        try{
            logger.info("start create or update token by user id");
            logger.info("transfer parameters >> userId:{}", userId);

            String token = AccreditTokenGenerator.generateValue();
            Date nowTime = new Date();
            Date expireTime = new Date(nowTime.getTime() + EXPIRE_TIME * 1000);
            UserTokenEntity userTokenEntity = userTokenMapper.findUserTokenByUserId(userId);
            if(ObjectUtil.isNotEmpty(userTokenEntity)){
                logger.info("userTokenEntity is not empty update user token ");
                userTokenEntity.setToken(token);
                userTokenEntity.setUpdateTime(nowTime);
                userTokenEntity.setExpireTime(expireTime);
                userTokenMapper.updateByEntity(userTokenEntity);
            }else{
                logger.info("userTokenEntity is empty insert user token ");
                userTokenEntity = new UserTokenEntity();
                userTokenEntity.setUserId(userId);
                userTokenEntity.setToken(token);
                userTokenEntity.setExpireTime(expireTime);
                userTokenEntity.setUpdateTime(nowTime);
                userTokenMapper.saveByEntity(userTokenEntity);
            }
            logger.info("return parameter >> token:{}", token);
            logger.info("end create or update token by user id");
            return new RespJsonData(token, BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson logout(Long userId) {
        try{
            logger.info("start logout");
            logger.info("transfer parameters >> userId:{}", userId);

            //生成一个token
            String token = AccreditTokenGenerator.generateValue();
            //修改token
            UserTokenEntity userTokenEntity = new UserTokenEntity();
            userTokenEntity.setUserId(userId);
            userTokenEntity.setToken(token);
            userTokenMapper.updateByEntity(userTokenEntity);

            logger.info("return parameter >> token:{}", token);
            logger.info("end logout");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }
}

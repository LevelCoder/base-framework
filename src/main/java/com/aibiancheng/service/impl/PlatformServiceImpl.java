package com.aibiancheng.service.impl;

import com.aibiancheng.entity.PlatformEntity;
import com.aibiancheng.exception.CustomException;
import com.aibiancheng.extension.PlatformExtension;
import com.aibiancheng.mapper.PlatformMapper;
import com.aibiancheng.model.bo.platform.AddPlatformBO;
import com.aibiancheng.model.bo.platform.EditPlatformBO;
import com.aibiancheng.model.bo.platform.FindPlatformBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.resp.RespJsonPageData;
import com.aibiancheng.service.PlatformService;
import com.aibiancheng.utils.BaseAuthConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:平台业务实现层
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
@Service("platformService")
public class PlatformServiceImpl implements PlatformService {

    private static Logger logger = LoggerFactory.getLogger(PlatformServiceImpl.class);

    @Autowired
    private PlatformMapper platformMapper;

    @Override
    public RespJson addPlatform(AddPlatformBO addPlatformBO) {
        try{
            logger.info("start add platform");
            logger.info("transfer parameters >> addPlatformBO:{}", JSON.toJSON(addPlatformBO));
            PlatformEntity platformEntity = PlatformExtension.addPlatform(addPlatformBO);
            String platformKey = null;
            String platformSecret = null;
            platformEntity.setPlatformKey(platformKey);
            platformEntity.setPlatformSecret(platformSecret);
            platformMapper.saveByEntity(platformEntity);
            logger.info("end add platform");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson editPlatform(EditPlatformBO editPlatformBO) {
        try{
            return null;
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson deletePlatform(Long platformId) {
        try{
            return null;
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJsonData viewPlatformDetail(Long platformId) {
        try{
            return null;
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJsonPageData viewPlatformList(FindPlatformBO findPlatformBO) {
        try{
            return null;
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }
}

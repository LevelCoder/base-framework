package com.aibiancheng.service.impl;

import com.aibiancheng.entity.ElementEntity;
import com.aibiancheng.exception.CustomException;
import com.aibiancheng.extension.ElementExtension;
import com.aibiancheng.mapper.AuthResourceMapper;
import com.aibiancheng.mapper.ElementMapper;
import com.aibiancheng.model.bo.element.AddElementBO;
import com.aibiancheng.model.bo.element.EditElementBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.service.ElementService;
import com.aibiancheng.utils.BaseAuthConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:元素／按钮 业务实现层
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
@Service("elementService")
public class ElementServiceImpl implements ElementService {

    private static Logger logger = LoggerFactory.getLogger(ElementServiceImpl.class);

    @Autowired
    private ElementMapper elementMapper;

    @Autowired
    private AuthResourceMapper authResourceMapper;

    @Override
    public RespJson addElement(AddElementBO addElementBO)  {
        try{
            logger.info("start add element");
            logger.info("transfer parameters >> addElementBO:{}", JSON.toJSON(addElementBO));

            ElementEntity elementEntity = ElementExtension.addElement(addElementBO);
            elementMapper.saveByEntity(elementEntity);

            logger.info("end add element");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson editElement(EditElementBO editElementBO)  {
        try{
            logger.info("start edit element");
            logger.info("transfer parameters >> editElementBO:{}", JSON.toJSON(editElementBO));

            ElementEntity elementEntity = ElementExtension.editElement(editElementBO);
            elementMapper.updateSelective(elementEntity);

            logger.info("end edit element");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson deleteElement(Long elementId)  {
        try{
            logger.info("start delete element");
            logger.info("transfer parameters >> elementId:{}", elementId);
            if(authResourceMapper.findAuthResourceByResource(elementId,"button") > 0){
                return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,"资源已分配,不允许删除");
            }
            elementMapper.deleteElementById(elementId);
            logger.info("end delete element");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJsonData viewElementDetail(Long elementId)  {
        try{
            logger.info("start view element detail");
            logger.info("transfer parameters >> elementId:{}", elementId);
            ElementEntity elementEntity = elementMapper.findElementInfoById(elementId);
            logger.info("end view element detail");
            return new RespJsonData(elementEntity,BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }
}

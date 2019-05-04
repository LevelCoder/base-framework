package com.aibiancheng.service.impl;

import com.aibiancheng.entity.AuthResourceEntity;
import com.aibiancheng.entity.LogRecordEntity;
import com.aibiancheng.exception.CustomException;
import com.aibiancheng.mapper.LogRecordMapper;
import com.aibiancheng.model.bo.log.FindLogRecordBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.resp.RespJsonPageData;
import com.aibiancheng.service.LogRecordService;
import com.aibiancheng.utils.BaseAuthConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/22
 */
@Service("logRecordService")
public class LogRecordServcieImpl implements LogRecordService {

    private static Logger logger = LoggerFactory.getLogger(LogRecordServcieImpl.class);

    @Autowired
    private LogRecordMapper logRecordMapper;


    @Override
    public RespJsonPageData viewLogRecordList(FindLogRecordBO findLogRecordBO) {
        return null;
    }


    @Override
    public RespJsonData viewLogRecordDetail(Long id)  {
        try{
            logger.info("start view log record ");
            logger.info("transfer parameters >> logId:{}", id);
            LogRecordEntity logRecordEntity = logRecordMapper.viewLogRecordDetail(id);
            logger.info("end view log record  ");
            return null;
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson deleteLogRecord(Long logId)  {
        try{
            logger.info("start delete log record ");
            logger.info("transfer parameters >> logId:{}", logId);
            logRecordMapper.deleteByLogId(logId);
            logger.info("end delete log record  ");
            return  null;
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }




}

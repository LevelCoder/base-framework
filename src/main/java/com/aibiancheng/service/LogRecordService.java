package com.aibiancheng.service;

import com.aibiancheng.model.bo.log.FindLogRecordBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.resp.RespJsonPageData;

/**
 * 描述:
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/22
 */
public interface LogRecordService {

    /**
     * 查看日志列表
     * @param findLogRecordBO
     * @return
     */
    RespJsonPageData viewLogRecordList(FindLogRecordBO findLogRecordBO);

    /**
     * 删除日志
     * @param logId
     * @return
     */
    RespJson deleteLogRecord(Long logId) ;

    /**
     * 查看日志详情
     * @param id
     * @return
     */
    RespJsonData viewLogRecordDetail(Long id) ;
}

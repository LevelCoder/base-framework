package com.aibiancheng.mapper;

import com.aibiancheng.entity.LogRecordEntity; /**
 * 描述:日志mapper
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/22
 */
public interface LogRecordMapper {

    /**
     * 插入日志
     * @param logRecordEntity
     */
    void saveByEntity(LogRecordEntity logRecordEntity);

    /**
     * 删除日志
     * @param logId
     */
    void deleteByLogId(Long logId);

    /**
     * 查看日志详情
     * @param id
     * @return
     */
    LogRecordEntity viewLogRecordDetail(Long id);
}

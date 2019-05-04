package com.aibiancheng.mapper;

import com.aibiancheng.entity.PlatformEntity;

/**
 * 描述:平台mapper
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public interface PlatformMapper {

    /**
     * 新增平台
     * @param platformEntity
     */
    void saveByEntity(PlatformEntity platformEntity);
}

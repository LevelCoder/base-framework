package com.aibiancheng.extension;

import com.aibiancheng.entity.PlatformEntity;
import com.aibiancheng.model.bo.platform.AddPlatformBO;

import java.util.Date;

/**
 * 描述:平台延展类
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/18
 */
public class PlatformExtension {

    /**
     * 新增平台
     * @param addPlatformBO
     * @return
     */
    public static PlatformEntity addPlatform(AddPlatformBO addPlatformBO) {
        PlatformEntity platformEntity = new PlatformEntity();
        platformEntity.setCreateTime(new Date());
        platformEntity.setPlatformName(addPlatformBO.getPlatformName());
        platformEntity.setPlatformInfo(addPlatformBO.getPlatformInfo());
        platformEntity.setPlatformCode(addPlatformBO.getPlatformCode());
        platformEntity.setPlatformState((byte)2);
        return platformEntity;
    }
}

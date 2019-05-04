package com.aibiancheng.service;

import com.aibiancheng.model.bo.platform.AddPlatformBO;
import com.aibiancheng.model.bo.platform.EditPlatformBO;
import com.aibiancheng.model.bo.platform.FindPlatformBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.resp.RespJsonPageData;

/**
 * 描述:平台service
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public interface PlatformService {

    /**
     * 新增平台信息
     * @param addPlatformBO
     * @return
     */
    RespJson addPlatform(AddPlatformBO addPlatformBO);


    /**
     * 修改平台信息
     * @param editPlatformBO
     * @return
     */
    RespJson editPlatform(EditPlatformBO editPlatformBO);

    /**
     * 删除平台信息
     * @param platformId
     * @return
     */
    RespJson deletePlatform(Long platformId);

    /**
     * 查看平台详情
     * @param platformId
     * @return
     */
    RespJsonData viewPlatformDetail(Long platformId);

    /**
     * 查看平台列表
     * @param findPlatformBO
     * @return
     */
    RespJsonPageData viewPlatformList(FindPlatformBO findPlatformBO);
}

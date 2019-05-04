package com.aibiancheng.model.bo.platform;

/**
 * 描述:新增平台
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/6
 */
public class AddPlatformBO {

    /** 平台名称 */
    private String platformName;

    /** 平台简介 */
    private String platformInfo;

    /** 平台编号 */
    private String platformCode;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformInfo() {
        return platformInfo;
    }

    public void setPlatformInfo(String platformInfo) {
        this.platformInfo = platformInfo;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }
}

package com.aibiancheng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:平台表
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public class PlatformEntity implements Serializable {

    /** 平台主键id */
    private Long id;

    /** 平台编号 */
    private String platformCode;

    /** 平台名称 */
    private String platformName;

    /** 平台key */
    private String platformKey;

    /** 平台秘钥 */
    private String platformSecret;

    /** 平台简介 */
    private String platformInfo;

    /** 平台状态 1.合作中 2.未合作 3.终止合作 */
    private Byte platformState;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTIme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    public String getPlatformKey() {
        return platformKey;
    }

    public void setPlatformKey(String platformKey) {
        this.platformKey = platformKey;
    }

    public String getPlatformSecret() {
        return platformSecret;
    }

    public void setPlatformSecret(String platformSecret) {
        this.platformSecret = platformSecret;
    }

    public String getPlatformInfo() {
        return platformInfo;
    }

    public void setPlatformInfo(String platformInfo) {
        this.platformInfo = platformInfo;
    }

    public Byte getPlatformState() {
        return platformState;
    }

    public void setPlatformState(Byte platformState) {
        this.platformState = platformState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTIme() {
        return updateTIme;
    }

    public void setUpdateTIme(Date updateTIme) {
        this.updateTIme = updateTIme;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public String toString() {
        return "PlatformEntity{" +
                "id=" + id +
                ", platformCode='" + platformCode + '\'' +
                ", platformName='" + platformName + '\'' +
                ", platformKey='" + platformKey + '\'' +
                ", platformSecret='" + platformSecret + '\'' +
                ", platformInfo='" + platformInfo + '\'' +
                ", platformState=" + platformState +
                ", createTime=" + createTime +
                ", updateTIme=" + updateTIme +
                '}';
    }
}

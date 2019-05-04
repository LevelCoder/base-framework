package com.aibiancheng.entity;

import java.io.Serializable;

/**
 * 描述:组织机构表
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public class OrganizationEntity implements Serializable {

    /** 主键id */
    private Long id;

    /** 组织名称 */
    private String orgName;

    /** 组织类别 */
    private String orgType;

    /** 组织描述 */
    private String orgDesc;

    /** 组织状态 1.启用 2.禁用*/
    private Byte orgState;

    /** 组织父id */
    private Long orgParentId;

    /** 创建人 为分级授权用 */
    private Long createUserId;

    /** 平台id 绑定管理:平台下的组织*/
    private Long platformId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }

    public Byte getOrgState() {
        return orgState;
    }

    public void setOrgState(Byte orgState) {
        this.orgState = orgState;
    }

    public Long getOrgParentId() {
        return orgParentId;
    }

    public void setOrgParentId(Long orgParentId) {
        this.orgParentId = orgParentId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    @Override
    public String toString() {
        return "OrganizationEntity{" +
                "id=" + id +
                ", orgName='" + orgName + '\'' +
                ", orgType='" + orgType + '\'' +
                ", orgDesc='" + orgDesc + '\'' +
                ", orgState=" + orgState +
                ", orgParentId=" + orgParentId +
                ", createUserId=" + createUserId +
                ", platformId=" + platformId +
                '}';
    }
}

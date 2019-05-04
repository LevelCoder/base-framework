package com.aibiancheng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:岗位对象
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/8/10
 */
public class PostEntity implements Serializable {

    /** 主键id */
    private Long id;

    /** 岗位编号 */
    private String postCode;

    /** 岗位名称 */
    private String postName;

    /** 岗位状态 1.启用 2.停用 */
    private String postStata;

    /** 岗位顺序*/
    private Integer postSort;

    /** 组织id 岗位关联组织信息 根据创建人所属组织自动填充 */
    private Long organizationId;

    /** 创建人id 一般为平台下组织超级管理员创建 */
    private Long createUserId;

    /** 创建人名称 */
    private String createUserName;

    /** 创建时间 */
    private Date createTime;

    /** 更新人id 一般为平台下组织超级管理员更新 */
    private Long updateUserId;

    /** 更新人名称 */
    private String updateUserName;

    /** 更新时间 */
    private Date updateTime;

    /** 岗位描述 */
    private String postDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostStata() {
        return postStata;
    }

    public void setPostStata(String postStata) {
        this.postStata = postStata;
    }

    public Integer getPostSort() {
        return postSort;
    }

    public void setPostSort(Integer postSort) {
        this.postSort = postSort;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }
}

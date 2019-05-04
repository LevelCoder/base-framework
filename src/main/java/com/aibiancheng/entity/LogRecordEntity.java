package com.aibiancheng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:日志记录表
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/22
 */
public class LogRecordEntity implements Serializable {

    private Long id;

    private String logModule;

    private String logMethod;

    private String logDesc;

    private String logIp;

    private String createUser;

    private Date createTime;

    private String logParams;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogModule() {
        return logModule;
    }

    public void setLogModule(String logModule) {
        this.logModule = logModule;
    }

    public String getLogMethod() {
        return logMethod;
    }

    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod;
    }

    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc;
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLogParams() {
        return logParams;
    }

    public void setLogParams(String logParams) {
        this.logParams = logParams;
    }

    @Override
    public String toString() {
        return "LogRecordEntity{" +
                "id=" + id +
                ", logModule='" + logModule + '\'' +
                ", logMethod='" + logMethod + '\'' +
                ", logDesc='" + logDesc + '\'' +
                ", logIp='" + logIp + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", logParams='" + logParams + '\'' +
                '}';
    }
}

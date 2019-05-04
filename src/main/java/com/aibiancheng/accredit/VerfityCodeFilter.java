package com.aibiancheng.accredit;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 描述:验证码过滤器
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/21
 */
public class VerfityCodeFilter extends AccessControlFilter {

    /** 引入 log 日志*/
    private static Logger logger = LoggerFactory.getLogger(VerfityCodeFilter.class);

    /** 是否开启验证码验证   默认true */
    private boolean verfitiCode = true;

    /** 前台提交的验证码name*/
    private String jcaptchaParam = "code";

    /** 验证失败后setAttribute key*/
    private String failureKeyAttribute = "shiroLoginFailure";

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object object) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return false;
    }

    public boolean isVerfitiCode() {
        return verfitiCode;
    }

    public void setVerfitiCode(boolean verfitiCode) {
        this.verfitiCode = verfitiCode;
    }

    public String getJcaptchaParam() {
        return jcaptchaParam;
    }

    public void setJcaptchaParam(String jcaptchaParam) {
        this.jcaptchaParam = jcaptchaParam;
    }

    public String getFailureKeyAttribute() {
        return failureKeyAttribute;
    }

    public void setFailureKeyAttribute(String failureKeyAttribute) {
        this.failureKeyAttribute = failureKeyAttribute;
    }
}

package com.aibiancheng.accredit;

import com.aibiancheng.utils.http.HttpContextUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 描述:授权凭证过滤器
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/21
 */
public class AccreditFilter extends AuthenticatingFilter {

    /** 引入日志 */
    private static Logger logger = LoggerFactory.getLogger(AccreditFilter.class);


    /**
     * 创建token
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected  AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        String token = getRequestToken((HttpServletRequest) request);
        if(StringUtils.isBlank(token)){
            return null;
        }
        return new AccreditToken(token);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if(((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name())){
            return true;
        }
        return false;
    }


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //获取请求token，如果token不存在，直接返回401
        String token = getRequestToken((HttpServletRequest) request);
        if(StringUtils.isBlank(token)){
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("responseCode",HttpStatus.SC_UNAUTHORIZED);
            jsonObject.put("responseMessage","invalid token");
            httpResponse.getWriter().print(jsonObject.toString());
            return false;
        }
        return executeLogin(request, response);
    }


    /**
     * 登录失败处理
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());
        try {
            //处理登录失败的异常
            Throwable throwable = e.getCause() == null ? e : e.getCause();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("responseCode",HttpStatus.SC_UNAUTHORIZED);
            jsonObject.put("responseMessage",throwable.getMessage());
            httpResponse.getWriter().print(jsonObject.toString());
        } catch (IOException e1) {
            logger.error("");
        }
        return false;
    }


    /**
     * 获取请求的token
     */
    private String getRequestToken(HttpServletRequest httpRequest){
        //从header中获取token
        String token = httpRequest.getHeader("token");
        //如果header中不存在token，则从参数中获取token
        if(StringUtils.isBlank(token)){
            token = httpRequest.getParameter("token");
        }
        return token;
    }

}

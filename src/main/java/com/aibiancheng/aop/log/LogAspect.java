package com.aibiancheng.aop.log;

import com.aibiancheng.entity.LogRecordEntity;
import com.aibiancheng.entity.UserEntity;
import com.aibiancheng.mapper.LogRecordMapper;
import com.aibiancheng.utils.basic.IpKitUtil;
import com.aibiancheng.utils.basic.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 描述:log 切面
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/22
 */

@Aspect
@Component
public class LogAspect {

    /**
     * 引入日志
     */
    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private LogRecordMapper logRecordMapper;


    /**
     * 引入需要执行aop切面的注解
     */
    @Pointcut("@annotation(com.aibiancheng.aop.log.LogAnnotation)")
    private void pointcut() {

    }


    /**
     * 在切面注解之后执行日志插入
     * @param joinPoint
     */
    @After("pointcut()")
    public void insertLogRecord(JoinPoint joinPoint) {
        addLogRecord(joinPoint, getLogDesc(joinPoint),getLogModule(joinPoint));
    }

    /**
     * 追加日志记录
     * @param joinPoint
     * @param logDesc
     */
    private void addLogRecord(JoinPoint joinPoint, String logDesc,String logModule) {
        LogEnum logEnum = getLogMethod(joinPoint);
        LogRecordEntity logRecordEntity = new LogRecordEntity();
        //通过spring 请求上下文 获取 request 属性信息
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //获取请求ip地址
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String ip = IpKitUtil.getRealIp(request);
            logRecordEntity.setLogIp(ip);
        }
        logRecordEntity.setLogModule(logModule);
        logRecordEntity.setLogDesc(logDesc);
        logRecordEntity.setLogMethod(logEnum.toString());
        Object[] objects = joinPoint.getArgs();
        String params = new Gson().toJson(objects[0]);
        logRecordEntity.setLogParams(params);
        //由于对账户信息进行拆分处理,有可能不存在userName,所以直接用账户的id来存储
        String username = ((UserEntity) SecurityUtils.getSubject().getPrincipal()).getNickName();
        logRecordEntity.setCreateUser(username);
        logRecordEntity.setCreateTime(new Date());
        logRecordMapper.saveByEntity(logRecordEntity);
    }

    /**
     * 根据joinPoint获取日志方法类型
     * @param joinPoint
     * @return
     */
    private LogEnum getLogMethod(JoinPoint joinPoint) {
        MethodSignature methodName = (MethodSignature) joinPoint.getSignature();
        Method method = methodName.getMethod();
        return method.getAnnotation(LogAnnotation.class).method();
    }

    /**
     * 通过joinPoint获取日志描述
     * @param joinPoint
     * @return
     */
    private String getLogDesc(JoinPoint joinPoint) {
        MethodSignature methodName = (MethodSignature) joinPoint.getSignature();
        Method method = methodName.getMethod();
        return method.getAnnotation(LogAnnotation.class).logDesc();
    }

    /**
     * 根据joinPoint获取日志模块
     * @param joinPoint
     * @return
     */
    private String getLogModule(JoinPoint joinPoint) {
        MethodSignature methodName = (MethodSignature) joinPoint.getSignature();
        Method method = methodName.getMethod();
        return method.getAnnotation(LogAnnotation.class).module();
    }

}

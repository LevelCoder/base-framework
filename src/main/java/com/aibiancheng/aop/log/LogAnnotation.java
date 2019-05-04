package com.aibiancheng.aop.log;

import java.lang.annotation.*;

/**
 * 描述:log注解
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/22
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {

    /**
     * 模块名称
     * @return
     */
    String module();

    /**
     * 日志描述
     * @return
     */
    String logDesc();

    /**
     * 方法类型:通过枚举类进行处理
     * @return
     */
    LogEnum method();
}

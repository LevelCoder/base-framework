package com.aibiancheng.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:检测ApplicationContext会自动检查是否在定义文件中有实现了BeanPostProcessor接口的类
 *     如果有的话，Spring容器会在每个Bean(其他的Bean)被初始化之前和初始化之后，
 *     分别调用实现了BeanPostProcessor接口的类的postProcessAfterInitialization()方法
 *     和postProcessBeforeInitialization()方法
 *     用于监听服务bean注册
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/21
 */

@Configuration
public class BeanInjectionConfiguration implements BeanPostProcessor {

    /**
     * 引入日志记录日志
     */
    private static Logger logger = LoggerFactory.getLogger(BeanInjectionConfiguration.class);

    /**
     * 定义Bean初始化前的动作
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)throws BeansException {
        logger.info("初始化开始 ******** 对象:{}",beanName);
        return bean;
    }


    /**
     * 定义Bean初始化后的动作
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("初始化成功 ******** 对象:{}",beanName);
        return bean;
    }
}

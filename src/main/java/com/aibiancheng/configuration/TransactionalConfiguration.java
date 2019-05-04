package com.aibiancheng.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.Properties;

/**
 * 描述:声明事物配置
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/21
 */
@Configuration
public class TransactionalConfiguration {

    /** 引入日志 */
    private static Logger logger = LoggerFactory.getLogger(TransactionalConfiguration.class);


    /** 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择 适用于save、update、delete等操作 */
    private static final String  PROPAGATION_REQUIRED="PROPAGATION_REQUIRED,-Throwable";

    /** 只读 不需要加入事物的元素 */
    private static final String  PROPAGATION_REQUIRED_READ="PROPAGATION_REQUIRED,-Throwable,readOnly";

    /**  需要加入事物的规则 */
    private static final String[]  REQUIRED_RULE_TRANSACTION={"create*","insert*","save*","add*","update*","modify*","change*","del*","bind*"};

    /** 不需要加入事物的规则,即只读 */
    private static final String[]  READ_RULE_TRANSACTION={"select*","get*","count*","find*"};



    /**
     * 事物拦截器
     * @param platformTransactionManager 自动注入 无需手动
     * @return
     */
    @Bean(name="transactions")
    public TransactionInterceptor transactionInterceptor(PlatformTransactionManager platformTransactionManager) throws Exception {
        try{
            logger.info(" ***************************** 配置事物拦截器 开始  *****************************");
            //定义事物拦截器
            TransactionInterceptor interceptor = new TransactionInterceptor();
            //定义属性信息
            Properties properties = new Properties();
            //遍历需要加入事物的属性信息
            for(String key:REQUIRED_RULE_TRANSACTION){
                properties.setProperty(key, PROPAGATION_REQUIRED);
            }
            //遍历不需要加入事物的属性
            for(String key:READ_RULE_TRANSACTION){
                properties.setProperty(key, PROPAGATION_REQUIRED_READ);
            }
            //设置事物管理器
            interceptor.setTransactionManager(platformTransactionManager);
            //设置事务属性
            interceptor.setTransactionAttributes(properties);
            logger.info(" ***************************** 配置事物拦截器 成功  *****************************");
            //返回拦截器信息
            return interceptor;
        }catch (Exception e){
            logger.error("***************************** 配置事物拦截器 失败   ***************************** e:{}",e);
            throw new Exception();
        }
    }


    /**
     * 配置声明式事务 利用BeanNameAutoProxyCreator自动创建事务代理
     * setBeanNames 监听serviceImpl 如果需要监听多处存在事物则用","进行分割
     * @return
     */
    @Bean
    public BeanNameAutoProxyCreator getBeanNameAutoProxyCreator(){
        BeanNameAutoProxyCreator proxyCreator=new BeanNameAutoProxyCreator();
        // 此属性指定目标类本省是否是代理的对象，如果目标类没有实现任何类，就设为true代表自己
        proxyCreator.setProxyTargetClass(true);
        proxyCreator.setBeanNames("*Service");
        proxyCreator.setInterceptorNames("transactions");
        return proxyCreator;
    }
}

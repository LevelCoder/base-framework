package com.aibiancheng.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * 描述:mybatis配置文件
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/21
 */
@Configuration
public class MybatisConfiguration {

    private Logger logger= LoggerFactory.getLogger(MybatisConfiguration.class);
    /** 配置类型别名 */
    @Value("${mybatis.typeAliasesPackage}")
    private String typeAliasesPackage;

    /**  配置mapper的扫描，找到所有的mapper.xml映射文件 */
    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    /** 加载全局的配置文件 */
    @Value("${mybatis.configLocation}")
    private String configLocation;


    @Autowired
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        try {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(dataSource);
            sessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
            Resource[] resources = new PathMatchingResourcePatternResolver().getResources(mapperLocations);
            sessionFactoryBean.setMapperLocations(resources);
            sessionFactoryBean.setConfigLocation( new DefaultResourceLoader().getResource(configLocation));
            return sessionFactoryBean.getObject();
        } catch (IOException e) {
            logger.warn("mybatis resolver mapper*xml is error");
            return null;
        } catch (Exception e) {
            logger.warn("mybatis sqlSessionFactoryBean create error");
            return null;
        }
    }
}

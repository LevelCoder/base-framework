package com.aibiancheng.configuration;

import com.aibiancheng.accredit.AccreditFilter;
import com.aibiancheng.accredit.AiBianChengRealm;
import com.aibiancheng.accredit.RetryLimitCredentialsMatcher;
import com.aibiancheng.accredit.VerfityCodeFilter;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 描述:shiro配置
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/21
 */
@Configuration
public class ShiroConfiguration {

    /**
     * 引入logger 日志
     */
    private static Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);


    /**
     * 注入ehcache缓存
     * @return
     */
    @Bean
    public EhCacheManager getCacheManager(){
        EhCacheManager ehCacheManager=new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:ehcache/ehcache.xml");
        return ehCacheManager;
    }



    /**
     * 注入 登录验证器,防止暴力破解 等同于 xml配置中 凭证匹配器 配置
     * @return
     */
    //@Bean
    public RetryLimitCredentialsMatcher getRetryLimitCredentialsMatcher(){
        RetryLimitCredentialsMatcher rm = new RetryLimitCredentialsMatcher(getCacheManager());
        rm.setHashAlgorithmName("md5");
        rm.setHashIterations(4);
        return rm;

    }

    /**
     * 注入自定义Realm
     * @return
     */
    @Bean(name = "aiBianChengRealm")
    public AiBianChengRealm getAiBianChengRealm(){
        AiBianChengRealm realm= new AiBianChengRealm();
       // realm.setCredentialsMatcher(getRetryLimitCredentialsMatcher());
        return realm;
    }

    /**
     * 注入 Shiro生命周期处理器
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }


    /**
     * 权限管理 自定义realm
     * @param aiBianChengRealm
     * @param sessionManager
     * @return
     */
    @Bean(name="securityManager")
    public SecurityManager getSecurityManager(@Qualifier("aiBianChengRealm") AiBianChengRealm aiBianChengRealm,SessionManager sessionManager){
        DefaultWebSecurityManager dwm=new DefaultWebSecurityManager();
        dwm.setRealm(aiBianChengRealm);
        dwm.setCacheManager(getCacheManager());
        dwm.setSessionManager(sessionManager);
        return dwm;
    }

    /**
     * 注入 shiro 会话管理器
     * @return
     */
    @Bean("sessionManager")
    public SessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdCookieEnabled(true);
        return sessionManager;
    }


    /**
     * 注入 权限过滤器
     * @return
     */
    @Bean
    public AccreditFilter getAccreditFilter(){
        return new AccreditFilter();
    }

    /**
     * 注入 验证码过滤器
     * @return
     */
    @Bean
    public VerfityCodeFilter getVerfityCodeFilter(){
        VerfityCodeFilter verfityCodeFilter= new VerfityCodeFilter();
        verfityCodeFilter.setFailureKeyAttribute("shiroLoginFailure");
        verfityCodeFilter.setJcaptchaParam("code");
        verfityCodeFilter.setVerfitiCode(true);
        return verfityCodeFilter;
    }

    /**
     * 注入shiro 过滤器
     * @param securityManager
     * @return
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager){
        // shiro 过滤器工厂
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilter.setSecurityManager(securityManager);
        //默认的登陆访问url
        shiroFilter.setLoginUrl("/login");
        //登陆成功后跳转的url
        shiroFilter.setSuccessUrl("/");
        //没有权限跳转的url
        shiroFilter.setUnauthorizedUrl("/global/error");

        // 过滤规则 自定义过滤器 复制到过滤器规则中
        Map<String, Filter> customFilters=new HashMap<>();
        customFilters.put("verCode",getVerfityCodeFilter());
        customFilters.put("oauth2",new AccreditFilter());
        shiroFilter.setFilters(customFilters);

        //过滤规则 对所有被Shiro 拦截的请求做声明
        Map<String, String> filterMap = new LinkedHashMap<>();
        //用户登录注销不做验证,但是需要做验证码校验
        filterMap.put("/login","anon");
        filterMap.put("/layout","anon");
        filterMap.put("/getverfityCode","anon");
        //druid数据源 不做权限校验
        filterMap.put("/druid/**","anon");
        //对外开放接口不做权限校验
        filterMap.put("/app/**","anon");
        //swagger 接口测试不做权限校验
        filterMap.put("/swagger/**","anon");
        filterMap.put("/swagger-ui.html","anon");
        filterMap.put("/swagger-resources/**","anon");
        //验证码 不做权限验证
        filterMap.put("/captcha.jpg", "anon");
        //验证操作不做权限验证
        filterMap.put("/validata/**","anon");
        //其余一律作授权验证:授权验证采用oauth2
        filterMap.put("/**", "oauth2");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }


    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    /**
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }



}

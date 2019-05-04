package com.aibiancheng.utils.security;

import com.aibiancheng.entity.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * 描述:shiro 工具类
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/25
 */
public class ShiroUtil {


    /**
     * 获取用户信息
     * @return
     */
    public static  UserEntity getUser() {
        return (UserEntity) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取用户id
     * @return
     */
    public static  Long getUserId() {
        return getUser().getId();
    }
}

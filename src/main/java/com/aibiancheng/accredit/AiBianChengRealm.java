package com.aibiancheng.accredit;

import com.aibiancheng.entity.UserEntity;
import com.aibiancheng.entity.UserTokenEntity;
import com.aibiancheng.model.accredit.AccreditCustomUser;
import com.aibiancheng.service.ShiroService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Set;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;

/**
 * 描述:自定义shiro realm
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/21
 */
@Component
public class AiBianChengRealm extends AuthorizingRealm {

    /** 引入日志 */
    private static Logger logger = LoggerFactory.getLogger(AiBianChengRealm.class);

    /** 引入shiro 通过shiro接口模式去做授权验证 */
    @Autowired
    private ShiroService shiroService;

    /** token */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof AccreditToken;
    }


    /**
     * 获取授权认证
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserEntity user = (UserEntity)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = shiroService.findUserAuthorizationInfo(user.getId());
        return info;
    }


    /**
     * 登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String accessToken = (String) token.getPrincipal();

        //根据accessToken，查询用户信息
        UserTokenEntity tokenEntity = shiroService.findByToken(accessToken);
        //token失效
        if(tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()){
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }
        //查询用户信息
        UserEntity userEntity = shiroService.findUserInfoByUserId(tokenEntity.getUserId());
        //账号锁定
        if(userEntity.getUserState() == 0){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        //更新token信息,已保证用户每次在操作时候可以获取token有效期 除非长时间不操作.减少用户每次都需要重新登录认证繁琐
        shiroService.updateToken(tokenEntity);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userEntity, accessToken, getName());
        return info;
    }
}

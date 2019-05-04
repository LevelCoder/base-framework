package com.aibiancheng.service.impl;

import com.aibiancheng.accredit.AccreditTokenGenerator;
import com.aibiancheng.entity.UserEntity;
import com.aibiancheng.entity.UserTokenEntity;
import com.aibiancheng.mapper.*;
import com.aibiancheng.model.accredit.AccreditCustomUser;
import com.aibiancheng.service.ShiroService;
import com.aibiancheng.utils.basic.ObjectUtil;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 描述:shiro业务实现层
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/21
 */
@Service("shiroService")
public class ShiroServiceImpl implements ShiroService {

    private static Logger logger = LoggerFactory.getLogger(ShiroServiceImpl.class);

    /** 设置token 过期时间 和session 时间一样 暂定为 半个小时  */
    private static final int EXPIRE_TIME = 1800 ;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private AuthResourceMapper authResourceMapper;

    @Autowired
    private UserTokenMapper userTokenMapper;

    @Override
    public SimpleAuthorizationInfo findUserAuthorizationInfo(Long userId) {
        //1.查询当前用户拥有的所有角色信息
        //2.查询当前用户拥有的所有角色所拥有的资源信息
        //3.
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> premissionsSet = new HashSet<String>();
        List<Long> rolelist = userRoleMapper.findRoleListByUserId(userId);
        //遍历所有角色信息,并获取所有角色所拥有的权限信息
        for(Long roleId : rolelist){
            List<String> permissions = authResourceMapper.findAuthResourceUrlByRoleId(roleId);
            if(ObjectUtil.isNotEmpty(permissions)){
                for(String permission:permissions){
                    if(ObjectUtil.isNotEmpty(permission)){
                        premissionsSet.add(permission);
                    }
                }
            }
        }
        simpleAuthorizationInfo.setStringPermissions(premissionsSet);
        return simpleAuthorizationInfo;
    }

    @Override
    public UserTokenEntity findByToken(String token) {
        return userTokenMapper.findByToken(token);
    }

    @Override
    public UserEntity findUserInfoByUserId(Long userId) {
        return userMapper.findUserInfoByUserId(userId);
    }

    @Override
    public AccreditCustomUser findAccreditCustomUser(Long userId) {

        //1.
        return null;
    }

    @Override
    public void updateToken(UserTokenEntity userTokenEntity) {
        try {
            Date nowTime = new Date();
            Date expireTime = new Date(nowTime.getTime() + EXPIRE_TIME * 1000);
            userTokenEntity.setUpdateTime(nowTime);
            userTokenEntity.setExpireTime(expireTime);
            userTokenMapper.updateByEntity(userTokenEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

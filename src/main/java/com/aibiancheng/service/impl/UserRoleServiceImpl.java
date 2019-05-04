package com.aibiancheng.service.impl;

import com.aibiancheng.entity.RoleEntity;
import com.aibiancheng.entity.UserEntity;
import com.aibiancheng.entity.UserRoleEntity;
import com.aibiancheng.exception.CustomException;
import com.aibiancheng.mapper.RoleMapper;
import com.aibiancheng.mapper.UserMapper;
import com.aibiancheng.mapper.UserRoleMapper;
import com.aibiancheng.model.bo.bind.UserRoleBO;
import com.aibiancheng.model.dto.bind.UserRoleDTO;
import com.aibiancheng.model.dto.bind.UserRoleDetailDTO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.service.UserRoleService;
import com.aibiancheng.utils.BaseAuthConstant;
import com.aibiancheng.utils.basic.ObjectUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:用户角色
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/26
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    private static Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public RespJsonData findUserRole(Long userId) {
        try{
            logger.info("start find user role ");
            logger.info("transfer parameters >> userId:{}", userId);

            //1.获取当前用户信息
            UserEntity userEntity = userMapper.findUserInfoByUserId(userId);
            //2.获取当前用户所拥有角色信息
            List<Long> roleList = userRoleMapper.findRoleListByUserId(userId);
            //3.获取所有角色信息
            List<RoleEntity> roleEntityList = roleMapper.findAll();
            //4.对用户信息进行基础绑定
            UserRoleDTO userRoleDTO = new UserRoleDTO();
            userRoleDTO.setUserId(userEntity.getId());
            userRoleDTO.setUserName(userEntity.getNickName());
            List<UserRoleDetailDTO> roleDeatilDTOList = new ArrayList<UserRoleDetailDTO>();
            //5.遍历用户角色和所有角色并进行角色绑定
            if(ObjectUtil.isNotEmpty(roleEntityList)){
                for(RoleEntity roleEntity:roleEntityList){
                    //6.绑定用户角色信息
                    UserRoleDetailDTO roleDeatilDTO = new UserRoleDetailDTO();
                    roleDeatilDTO.setRoleId(roleEntity.getId());
                    roleDeatilDTO.setRoleName(roleEntity.getRoleName());
                    if(ObjectUtil.isNotEmpty(roleList)){
                        if(roleList.contains(roleEntity.getId())){
                            roleDeatilDTO.setRoleCheckState(1);
                        }else{
                            roleDeatilDTO.setRoleCheckState(2);
                        }
                    }else{
                        roleDeatilDTO.setRoleCheckState(2);
                    }
                    roleDeatilDTOList.add(roleDeatilDTO);
                }
            }
            userRoleDTO.setUserRoleDetailDTOList(roleDeatilDTOList);

            logger.info("return parameter >> userRoleDTO:{}",JSON.toJSON(userRoleDTO));
            logger.info("end find user role ");
            return new RespJsonData(userRoleDTO, BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson bindUserRole(UserRoleBO userRoleBO){
        try{
            logger.info("start bind user role ");
            logger.info("transfer parameters >> userRoleBO:{}", JSON.toJSON(userRoleBO));

            userRoleMapper.deleteByUserId(userRoleBO.getUserId());
            if(ObjectUtil.isNotEmpty(userRoleBO.getRoleIds())){
                List<UserRoleEntity> userRoleEntityList = new ArrayList<UserRoleEntity>();
                for(Long roleId : userRoleBO.getRoleIds()) {
                    UserRoleEntity userRoleEntity = new UserRoleEntity();
                    userRoleEntity.setUserId(userRoleBO.getUserId());
                    userRoleEntity.setRoleId(roleId);
                    userRoleEntityList.add(userRoleEntity);
                }
                userRoleMapper.saveBatchByEntity(userRoleEntityList);
            }

            logger.info("end bind user role ");
            return new RespJson( BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }
}

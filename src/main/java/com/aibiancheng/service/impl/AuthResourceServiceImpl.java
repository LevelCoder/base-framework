package com.aibiancheng.service.impl;

import com.aibiancheng.entity.AuthResourceEntity;
import com.aibiancheng.entity.ElementEntity;
import com.aibiancheng.entity.MenuEntity;
import com.aibiancheng.exception.CustomException;
import com.aibiancheng.mapper.AuthResourceMapper;
import com.aibiancheng.mapper.ElementMapper;
import com.aibiancheng.mapper.MenuMapper;
import com.aibiancheng.mapper.RoleMapper;
import com.aibiancheng.model.bo.bind.RoleElementBO;
import com.aibiancheng.model.bo.bind.RoleMenuBO;
import com.aibiancheng.model.bo.bind.RoleResourceElementBO;
import com.aibiancheng.model.dto.bind.RoleResourceElementDTO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.service.AuthResourceService;
import com.aibiancheng.utils.BaseAuthConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:资源授权业务实现层
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
@Service("authResourceService")
public class AuthResourceServiceImpl implements AuthResourceService {

    /** 引入日志 */
    private static Logger logger = LoggerFactory.getLogger(AuthResourceServiceImpl.class);

    @Autowired
    private AuthResourceMapper authResourceMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private ElementMapper elementMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RespJsonData findRoleResourceMenu(Long roleId) {
        try{
            logger.info("start find role resource menu ");
            logger.info("transfer parameters >> roleId:{}", roleId);

            //1.根据roleId查询所有权限为菜单的
            List<Long> authResourceEntityList = authResourceMapper.findAuthResourceMenuListByRoleId(roleId);
            //2.获取所有可用菜单信息
            List<MenuEntity> menuEntityList = menuMapper.findAll();
            //3.匹配判断是否被选中



            logger.info("return parameter >> ");
            logger.info("end find role resource menu ");
            return new RespJsonData(menuEntityList,BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson bindRoleResourceMenu(RoleMenuBO roleMenuBO)  {
        try{
            logger.info("start bind role resource menu ");
            logger.info("transfer parameters >> roleMenuBO:{}", JSON.toJSON(roleMenuBO));

            //1.根据角色信息删除所有菜单信息
            authResourceMapper.deleteRoleResourceMenuByRoleId(roleMenuBO.getRoleId());
            //2.根据选中菜单信息和角色信息追加角色功能
            List<AuthResourceEntity> authResourceEntityList = new ArrayList<AuthResourceEntity>();
            for(Long menuId : roleMenuBO.getMenuIds()){
                AuthResourceEntity authResourceEntity = new AuthResourceEntity();
                authResourceEntity.setRoleId(roleMenuBO.getRoleId());
                authResourceEntity.setRoleType(roleMapper.findRoleTypeByRoleId(roleMenuBO.getRoleId()));
                authResourceEntity.setResourceId(menuId);
                authResourceEntity.setResourceType("menu");
                authResourceEntityList.add(authResourceEntity);
            }
            authResourceMapper.saveBatchByEntity(authResourceEntityList);

            logger.info("end bind role resource menu ");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJsonData findRoleResourceElement(RoleResourceElementBO roleResourceElementBO) {
        try{
            logger.info("start find role resource element ");
            logger.info("transfer parameters >> roleResourceElementBO:{}", JSON.toJSON(roleResourceElementBO));

            //1.根据roleId查询资源列表为按钮的元素列表
            List<Long> elementResourceList = authResourceMapper.findAuthResourceElementListByRoleId(roleResourceElementBO.getRoleId());
            //2.根据menuId查询所有元素列表
            List<ElementEntity> elementEntityList = elementMapper.findElementListByMenuId(roleResourceElementBO.getMenuId());
            //3.对比判断当角色所分配的功能是否存在被选中的,并返回对应的元素对象列表
            List<RoleResourceElementDTO> roleResourceElementDTOList = new ArrayList<RoleResourceElementDTO>();
            for(ElementEntity elementEntity : elementEntityList){
                RoleResourceElementDTO roleResourceElementDTO = new RoleResourceElementDTO();
                roleResourceElementDTO.setElementId(elementEntity.getId());
                roleResourceElementDTO.setElementCode(elementEntity.getElementCode());
                roleResourceElementDTO.setElementName(elementEntity.getElementName());
                roleResourceElementDTO.setElementType(elementEntity.getElementType());
                roleResourceElementDTO.setElementUrl(elementEntity.getElementUrl());
                roleResourceElementDTO.setElementDesc(elementEntity.getElementDesc());
                if(elementResourceList.contains(elementEntity.getId())){
                    roleResourceElementDTO.setElementCheckState(1);
                }else{
                    roleResourceElementDTO.setElementCheckState(2);
                }
                roleResourceElementDTOList.add(roleResourceElementDTO);
            }

            logger.info("return parameter >> roleResourceElementDTOList:{}",JSON.toJSON(roleResourceElementDTOList));
            logger.info("end find role resource element ");
            return new RespJsonData(roleResourceElementDTOList,BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson bindRoleResourceElement(RoleElementBO roleElementBO) {
        try{
            logger.info("start bind role resource element ");
            logger.info("transfer parameters >> roleElementBO:{}", JSON.toJSON(roleElementBO));

            AuthResourceEntity authResourceEntity = new AuthResourceEntity();
            authResourceEntity.setResourceId(roleElementBO.getElementId());
            authResourceEntity.setResourceType("button");
            authResourceEntity.setRoleId(roleElementBO.getRoleId());
            authResourceEntity.setRoleType(roleMapper.findRoleTypeByRoleId(roleElementBO.getRoleId()));
            authResourceMapper.saveByEntity(authResourceEntity);

            logger.info("end bind role resource element ");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson removeRoleResourceElement(RoleElementBO roleElementBO)  {
        try{
            logger.info("start remove role resource element ");
            logger.info("transfer parameters >> roleElementBO:{}", JSON.toJSON(roleElementBO));

            authResourceMapper.removeRoleResourceElement(roleElementBO.getRoleId(),roleElementBO.getElementId());

            logger.info("end bind remove resource element ");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }
}

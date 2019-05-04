package com.aibiancheng.service.impl;

import com.aibiancheng.entity.RoleEntity;
import com.aibiancheng.entity.UserEntity;
import com.aibiancheng.exception.CustomException;
import com.aibiancheng.mapper.AuthResourceMapper;
import com.aibiancheng.mapper.RoleMapper;
import com.aibiancheng.mapper.UserMapper;
import com.aibiancheng.mapper.UserRoleMapper;
import com.aibiancheng.model.bo.role.AddRoleBO;
import com.aibiancheng.model.bo.role.EditRoleBO;
import com.aibiancheng.model.bo.role.FindRoleBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.resp.RespJsonPageData;
import com.aibiancheng.service.RoleService;
import com.aibiancheng.utils.BaseAuthConstant;
import com.aibiancheng.utils.basic.ObjectUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:角色业务实现层
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    private static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private AuthResourceMapper authResourceMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public RespJson addRole(AddRoleBO addRoleBO,Long userId)  {
        try{
            logger.info("start add role ");
            logger.info("transfer parameters >> addRoleBO:{},userId:{}", JSON.toJSON(addRoleBO),userId);

            //判断当前创建角色用户类型.如果为系统用户则判断角色类型是否为空,如果不为空则根据传递过来的数据进行判断.否则为系统用户
            UserEntity userEntity = userMapper.findUserInfoByUserId(userId);

            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setRoleName(addRoleBO.getRoleName());
            roleEntity.setRoleState((byte)1);
            roleEntity.setRoleDesc(addRoleBO.getRoleDesc());
            roleEntity.setCreateUserId(userId);
            if(userEntity.getUserType() == 1){
                if(ObjectUtil.isNotEmpty(addRoleBO.getRoleType())){
                    roleEntity.setRoleType(addRoleBO.getRoleType());
                }else{
                    roleEntity.setRoleType(BaseAuthConstant.variable.ROLE_TYPE_SYSTEM);
                }
            }else{
                roleEntity.setRoleType(BaseAuthConstant.variable.ROLE_TYPE_BUSSINESS);
            }
            roleMapper.saveByEntity(roleEntity);

            logger.info("end add role ");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson eidtRole(EditRoleBO editRoleBO,Long userId)  {
        try{
            logger.info("start edit role ");
            logger.info("transfer parameters >> editRoleBO:{}", JSON.toJSON(editRoleBO));

            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setId(editRoleBO.getId());
            roleEntity.setRoleName(editRoleBO.getRoleName());
            roleEntity.setRoleDesc(editRoleBO.getRoleDesc());
            roleEntity.setCreateUserId(userId);
            roleMapper.updateSelective(roleEntity);

            logger.info("end edit role ");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson deleteRole(Long roleId) {
        try{
            logger.info("start delete role ");
            logger.info("transfer parameters >> roleId:{}", roleId);

            RoleEntity roleEntity = roleMapper.findRoleByRoleId(roleId);
            if(ObjectUtil.isNotEmpty(roleEntity)){
                if(userRoleMapper.findUserRoleCountByRoleId(roleId) > 0){
                    return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,"角色已分配,不允许删除");
                }
                authResourceMapper.deleteRoleResourceMenuByRoleId(roleId);
                roleMapper.deleteRoleById(roleId);

                logger.info("end delete role ");
                return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
            }else{
                logger.info("end delete role ");
                return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,"角色不存在");
            }
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJsonData viewRoleDetail(Long roleId)  {
        try{
            logger.info("start view role detail  ");
            logger.info("transfer parameters >> roleId:{}", roleId);

            RoleEntity roleEntity = roleMapper.findRoleByRoleId(roleId);

            logger.info("end view role detail  ");
            return new RespJsonData(roleEntity,BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJsonPageData viewRoleList(FindRoleBO findRoleBO,Long userId) {
        try{
            logger.info("start view role list  ");
            logger.info("transfer parameters >> addRoleBO:{}", JSON.toJSON(findRoleBO));

            if(userId == BaseAuthConstant.variable.ADMIN){

            }else{

            }
            logger.info("end view role list  ");
            return null;
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson changeRoleState(Long roleId, byte roleState) {
        try{
            logger.info("start change role state  ");
            logger.info("transfer parameters >> roleId:{},roleState:{}", roleId,roleState);

            RoleEntity roleEntity = roleMapper.findRoleByRoleId(roleId);
            if(ObjectUtil.isNotEmpty(roleEntity)){
                roleMapper.changeRoleState(roleId,roleState);
                logger.info("end change role state ");
                return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
            }else{
                logger.info("end change role state ");
                return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,"角色不存在");
            }
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }
}

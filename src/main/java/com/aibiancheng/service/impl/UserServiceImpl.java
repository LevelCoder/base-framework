package com.aibiancheng.service.impl;

import com.aibiancheng.entity.AuthResourceEntity;
import com.aibiancheng.entity.UserEntity;
import com.aibiancheng.entity.UserLocalAuthEntity;
import com.aibiancheng.exception.CustomException;
import com.aibiancheng.extension.UserExtension;
import com.aibiancheng.extension.UserLocalAuthExtension;
import com.aibiancheng.mapper.UserLocalAuthMapper;
import com.aibiancheng.mapper.UserMapper;
import com.aibiancheng.mapper.UserRoleMapper;
import com.aibiancheng.model.bo.user.AddUserBO;
import com.aibiancheng.model.bo.user.BackUserPassWordBO;
import com.aibiancheng.model.bo.user.EditUserBO;
import com.aibiancheng.model.bo.user.FindUserListBO;
import com.aibiancheng.model.dto.user.UserDetailDTO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.resp.RespJsonPageData;
import com.aibiancheng.service.UserService;
import com.aibiancheng.utils.BaseAuthConstant;
import com.aibiancheng.utils.basic.ObjectUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:用户管理实现层
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 引入日志
     */
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserLocalAuthMapper userLocalAuthMapper;

    /** 引入密码注解:系统新增用户,或者重制账户密码时候使用 */
    @Value("${password.default}")
    private String defaultPassWord;


    @Override
    public Byte findUserStateByUserId(Long userId)  {
        try{
            logger.info("start find user state by user id");
            logger.info("transfer parameters >> userId:{}", userId);

            Byte userState = userMapper.findUserStateByUserId(userId);

            logger.info("return parameter >> userState:{}", userState);
            logger.info("end find user local auth info by user name");
            return userState;
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public UserEntity findUserInfoByUserPhone(String userName) {
        return null;
    }

    /**
     * 所有用户列表
     * 1.如果当前登录人员为超级管理员则拥有最大权限
     * 2.如果为区域管理员则只拥有自己区域权限
     * 3.如果拥有被授权角色,则拥有被授权角色权限
     * 4.如果不是以上3点则只能查看自己的信息
     * @param findUserListBO
     * @return
     */
    @Override
    public RespJsonPageData viewUserList(FindUserListBO findUserListBO) {
        try{
            logger.info("start view user list");
            logger.info("transfer parameters >> findUserListBO:{}", JSON.toJSON(findUserListBO));


            logger.info("return parameter >> userState:{}");
            logger.info("end view user list");
            return null;
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJsonData viewUserDetail(Long userId) {
        try{
            logger.info("start view user detail");
            logger.info("transfer parameters >> userId:{}", userId);

            //查询用户基础信息.根据用户类型查看用户详细信息.相信信息根据用户拓展表进行查询并最终封装
            UserEntity userEntity = userMapper.findUserInfoByUserId(userId);
            //初步先查询用户基本信息.后续拓展可根据业务进行拓展.返回DTO对象可根据业务进行封装
            logger.info("return parameter >> userState:{}");
            logger.info("end view user detail");
            return new RespJsonData(userEntity,BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson addUser(AddUserBO addUserBO) {
        try{
            logger.info("start add user");
            logger.info("transfer parameters >> addUserBO:{}", JSON.toJSON(addUserBO));
            UserEntity userEntity = UserExtension.addUser(addUserBO);
            userMapper.insertByEntity(userEntity);
            List<UserLocalAuthEntity> userLocalAuthEntityList = new ArrayList<UserLocalAuthEntity>();
            String salt = RandomStringUtils.randomAlphanumeric(20);
            if(ObjectUtil.isNotEmpty(addUserBO.getUserName())){
                userLocalAuthEntityList.add(UserLocalAuthExtension.addUserLocalAuth(userEntity.getId(),addUserBO.getUserName() , defaultPassWord,salt));
            }
            if(ObjectUtil.isNotEmpty(addUserBO.getUserPhone())){
                userLocalAuthEntityList.add(UserLocalAuthExtension.addUserLocalAuth(userEntity.getId(),addUserBO.getUserPhone() , defaultPassWord,salt));
            }
            if(ObjectUtil.isNotEmpty(addUserBO.getUserEmail())){
                userLocalAuthEntityList.add(UserLocalAuthExtension.addUserLocalAuth(userEntity.getId(),addUserBO.getUserEmail() , defaultPassWord,salt));
            }
            userLocalAuthMapper.saveBatchByEntity(userLocalAuthEntityList);
            logger.info("end add user");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    /**
     * 修改用户:手机号和邮箱需要做验证,所以不允许在用户修改时直接进行变更.需要通过单独接口进行变更
     * @param editUserBO
     * @return
     */
    @Override
    public RespJson editUser(EditUserBO editUserBO)  {
        try{
            logger.info("start edit user ");
            logger.info("transfer parameters >> editUserBO:{}", JSON.toJSON(editUserBO));

            UserEntity userEntity = new UserEntity();
            userEntity.setId(editUserBO.getId());
            userEntity.setNickName(editUserBO.getNickName());
            userEntity.setUserAddress(editUserBO.getUserAddress());
            userEntity.setUserPhoto(editUserBO.getUserPhoto());
            userMapper.updateSelective(userEntity);

            logger.info("end edit user ");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    /**
     * 先查询当前用户信息,判断当前用户类型.根据用户类型去延展表中删除对应信息.
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public RespJson deleteUser(Long userId)  {
        try{
            logger.info("start delete user");
            logger.info("transfer parameters >> userId:{}", userId);

            UserEntity userEntity = userMapper.findUserInfoByUserId(userId);
            if(ObjectUtil.isNotEmpty(userEntity)){
                if(userEntity.getId() == 1L){
                    return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,"超级管理员不能删除");
                }
                userMapper.deleteUserByUserId(userId);
                userLocalAuthMapper.deleteUserLocalAuthByUserId(userId);
                logger.info("end delete user");
                return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
            }else{
                logger.error("end delete user");
                return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,BaseAuthConstant.responseUserMessage.USER_DOES_NOT_EXIST);
            }
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson changeUserState(Long userId, byte userState) {
        try{
            logger.info("start change user state");
            logger.info("transfer parameters >> userId:{},userState:{}", userId,userState);

            userMapper.changeUserState(userId,userState);

            logger.error("end delete user");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }



    @Override
    public RespJson resetPassWord(Long userId) {
        try{
            logger.info("start reset user pass word");
            logger.info("transfer parameters >> userId:{}", userId);

            List<UserLocalAuthEntity> userLocalAuthEntities = userLocalAuthMapper.findUserLocalAuthListByUserId(userId);
            if(ObjectUtil.isNotEmpty(userLocalAuthEntities)){
                List<UserLocalAuthEntity> userLocalAuthEntityList = new ArrayList<UserLocalAuthEntity>();
                for(UserLocalAuthEntity userLocalAuth:userLocalAuthEntities){
                    userLocalAuth.setPassWord(new Sha256Hash(defaultPassWord+userLocalAuth.getLoginName(),userLocalAuth.getSalt()).toHex());
                    userLocalAuthEntityList.add(userLocalAuth);
                }
                userLocalAuthMapper.updateBatchByEntity(userLocalAuthEntityList);
            }

            logger.error("end reset user pass word");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson backUserPassWord(BackUserPassWordBO backUserPassWordBO)  {
        try{
            logger.info("start back user pass word");
            logger.info("transfer parameters >> backUserPassWordBO:{}", JSON.toJSON(backUserPassWordBO));



            logger.error("end back user pass word");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson validataUserEmail(String userEmail)  {
        try{
            if(userMapper.findUserEmailExist(userEmail) > 0 ){
                return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,BaseAuthConstant.responseUserMessage.USER_EMAIL_EXIST);
            }else{
                return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,"验证通过");
            }
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson validataUserPhone(String userPhone)  {
        try{
            if(userMapper.findUserPhoneExist(userPhone) > 0 ){
                return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,BaseAuthConstant.responseUserMessage.USER_PHONE_EXIST);
            }else{
                return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,"验证通过");
            }
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson validataUserName(String userName) {
        try{
            if(userMapper.findUserNameExist(userName) > 0 ){
                return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,BaseAuthConstant.responseUserMessage.USER_NAME_EXIST);
            }else{
                return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,"验证通过");
            }
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }
}

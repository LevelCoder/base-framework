package com.aibiancheng.service;

import com.aibiancheng.entity.UserEntity;
import com.aibiancheng.model.bo.user.AddUserBO;
import com.aibiancheng.model.bo.user.BackUserPassWordBO;
import com.aibiancheng.model.bo.user.EditUserBO;
import com.aibiancheng.model.bo.user.FindUserListBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.resp.RespJsonPageData;
import org.apache.ibatis.annotations.Param;

/**
 * 描述:用户service
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public interface UserService {

    /**
     * 根据用户id查询用户状态
     * @param userId
     * @return
     */
    Byte findUserStateByUserId(@Param("userId") Long userId) ;

    /**
     * 根据用户手机号获取用户信息
     * @param userName
     * @return
     */
    UserEntity findUserInfoByUserPhone(String userName);

    /**
     * 查看用户列表
     * @param findUserListBO
     * @return
     */
    RespJsonPageData viewUserList(FindUserListBO findUserListBO) ;

    /**
     * 根据永固id查询用户详情
     * @param userId
     * @return
     */
    RespJsonData viewUserDetail(Long userId) ;

    /**
     * 新增用户
     * @param addUserBO
     * @return
     */
    RespJson addUser(AddUserBO addUserBO) ;

    /**
     * 修改用户
     * @param editUserBO
     * @return
     */
    RespJson editUser(EditUserBO editUserBO) ;

    /**
     * 删除用户
     * @param userId
     * @return
     */
    RespJson deleteUser(Long userId) ;

    /**
     * 修改用户状态
     * @param userId
     * @param b
     * @return
     */
    RespJson changeUserState(Long userId, byte b) ;

    /**
     * 重置用户密码
     * @param userId
     * @return
     */
    RespJson resetPassWord(Long userId) ;

    /**
     * 用户密码找回/忘记密码
     * @param backUserPassWordBO
     * @return
     */
    RespJson backUserPassWord(BackUserPassWordBO backUserPassWordBO) ;

    /**
     * 验证邮箱是否存在
     * @param userEmail
     * @return
     */
    RespJson validataUserEmail(String userEmail) ;

    /**
     * 验证手机号是否存在
     * @param userPhone
     * @return
     */
    RespJson validataUserPhone(String userPhone) ;

    /**
     * 验证用户名是否存在
     * @param userName
     * @return
     */
    RespJson validataUserName(String userName) ;
}

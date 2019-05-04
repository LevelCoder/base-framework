package com.aibiancheng.mapper;

import com.aibiancheng.entity.UserRoleEntity;

import java.util.List;

/**
 * 描述:用户角色关联mapper
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public interface UserRoleMapper {

    /**
     * 根据用户id查询所有角色信息
     * @param userId
     * @return
     */
    List<Long> findRoleListByUserId(Long userId);


    /**
     * 根据用户id删除角色信息
     * @param userId
     */
    void deleteByUserId(Long userId);

    /**
     * 批量增加
     * @param userRoleEntityList
     */
    void saveBatchByEntity(List<UserRoleEntity> userRoleEntityList);

    /**
     * 查询角色分配数量
     * @param roleId
     * @return
     */
    int findUserRoleCountByRoleId(Long roleId);
}

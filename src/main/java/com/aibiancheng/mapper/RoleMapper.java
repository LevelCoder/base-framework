package com.aibiancheng.mapper;

import com.aibiancheng.entity.RoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述:角色mapper
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public interface RoleMapper {

    /**
     * 新增角色
     * @param roleEntity
     */
    void saveByEntity(RoleEntity roleEntity);

    /**
     * 修改角色
     * @param roleEntity
     */
    void updateSelective(RoleEntity roleEntity);

    /**
     * 删除角色
     * @param roleId
     */
    void deleteRoleById(Long roleId);

    /**
     * 查询所有角色信息
     * @return
     */
    List<RoleEntity> findAll();

    /**
     * 根据roleId查询角色类型
     * @param roleId
     * @return
     */
    String findRoleTypeByRoleId(@Param("id") Long roleId);

    /**
     * 修改角色状态
     * @param roleId
     * @param roleState
     */
    void changeRoleState(@Param("roleId") Long roleId, @Param("roleState") byte roleState);

    /**
     * 根据roleId查询角色信息
     * @param roleId
     * @return
     */
    RoleEntity findRoleByRoleId(Long roleId);
}

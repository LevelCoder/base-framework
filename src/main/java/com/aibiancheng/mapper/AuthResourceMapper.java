package com.aibiancheng.mapper;

import com.aibiancheng.entity.AuthResourceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述:资源授权mapper
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public interface AuthResourceMapper {

    /**
     * 根据roleId查询当前角色所拥有菜单列表
     * @param roleId
     * @return
     */
    List<Long> findAuthResourceMenuListByRoleId(Long roleId);

    /**
     * 根据roleId查询当前角色所拥有元素列表
     * @param roleId
     * @return
     */
    List<Long> findAuthResourceElementListByRoleId(Long roleId);

    /**
     * 绑定角色元素信息
     * @param authResourceEntity
     */
    void saveByEntity(AuthResourceEntity authResourceEntity);


    /**
     * 移除元素
     * @param roleId
     * @param elementId
     */
    void removeRoleResourceElement(@Param("roleId") Long roleId, @Param("resourceId") Long elementId);

    /**
     * 根据roleId删除当前角色所拥有菜单信息
     * @param roleId
     */
    void deleteRoleResourceMenuByRoleId(Long roleId);

    /**
     * 批量保存
     * @param authResourceEntityList
     */
    void saveBatchByEntity(List<AuthResourceEntity> authResourceEntityList);

    /**
     * 根据roleId查询所有资源Url
     * @param roleId
     * @return
     */
    List<String> findAuthResourceUrlByRoleId(Long roleId);

    /**
     * 根据资源id和资源类型查看是否已分配
     * @param resourceId
     * @return
     */
    int findAuthResourceByResource(@Param("resourceId") Long resourceId,@Param("resourceType") String resourceType);
}

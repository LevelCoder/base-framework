package com.aibiancheng.mapper;

import com.aibiancheng.entity.MenuEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述:菜单mapper
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public interface MenuMapper {

    /**
     * 查询所有菜单信息(状态为使用中的)
     * @return
     */
    List<MenuEntity> findAll();

    /**
     * 修改菜单状态
     * @param menuId
     * @param menuState
     */
    void changeMenu(@Param("menuId") Long menuId, @Param("menuState") byte menuState);

    /**
     * 根据menuId删除菜单
     * @param menuId
     */
    void deleteById(Long menuId);

    /**
     * 根据菜单id查询菜单信息
     * @return
     */
    MenuEntity findMenuDetailById(Long menuId);

    /**
     * 新增菜单
     * @param menuEntity
     */
    void saveByEntity(MenuEntity menuEntity);

    /**
     * 修改菜单
     * @param menuEntity
     */
    void updateSelective(MenuEntity menuEntity);
}

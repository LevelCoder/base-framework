package com.aibiancheng.mapper;

import com.aibiancheng.entity.ElementEntity;

import java.util.List;

/**
 * 描述:元素/按钮mapper
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public interface ElementMapper {

    /**
     * 根据菜单id查询所有按钮列表
     * @param menuId
     * @return
     */
    List<ElementEntity> findElementListByMenuId(Long menuId);

    /**
     * 插入元素
     * @param elementEntity
     */
    void saveByEntity(ElementEntity elementEntity);

    /**
     * 修改元素
     * @param elementEntity
     */
    void updateSelective(ElementEntity elementEntity);

    /**
     * 根据id删除元素信息
     * @param elementId
     */
    void deleteElementById(Long elementId);

    /**
     * 根据id查看元素信息
     * @param id
     * @return
     */
    ElementEntity findElementInfoById(Long id);
}

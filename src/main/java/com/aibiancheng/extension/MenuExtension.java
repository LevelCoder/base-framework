package com.aibiancheng.extension;

import com.aibiancheng.entity.MenuEntity;
import com.aibiancheng.model.bo.menu.AddMenuBO;
import com.aibiancheng.model.bo.menu.EditMenuBO; /**
 * 描述:菜单延展类
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/3
 */
public class MenuExtension {

    /**
     * 新增菜单
     * @param addMenuBO
     * @return
     */
    public static MenuEntity addMenu(AddMenuBO addMenuBO) {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setMenuType(addMenuBO.getMenuType());
        menuEntity.setMenuSort(addMenuBO.getMenuSort());
        menuEntity.setMenuParentId(addMenuBO.getMenuParentId() == null ? 0L : addMenuBO.getMenuParentId());
        menuEntity.setMenuState((byte)2);
        menuEntity.setMenuUrl(addMenuBO.getMenuUrl());
        menuEntity.setMenuDesc(addMenuBO.getMenuDesc());
        menuEntity.setMenuIcon(addMenuBO.getMenuIcon());
        menuEntity.setMenuName(addMenuBO.getMenuName());
        menuEntity.setMenuCode(addMenuBO.getMenuCode());
        return menuEntity;
    }

    /**
     * 修改菜单
     * @param editMenuBO
     * @return
     */
    public static MenuEntity editMenu(EditMenuBO editMenuBO) {

        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setId(editMenuBO.getId());
        menuEntity.setMenuType(editMenuBO.getMenuType());
        menuEntity.setMenuSort(editMenuBO.getMenuSort());
        menuEntity.setMenuParentId( editMenuBO.getMenuParentId());
        menuEntity.setMenuState(editMenuBO.getMenuState());
        menuEntity.setMenuUrl(editMenuBO.getMenuUrl());
        menuEntity.setMenuDesc(editMenuBO.getMenuDesc());
        menuEntity.setMenuIcon(editMenuBO.getMenuIcon());
        menuEntity.setMenuName(editMenuBO.getMenuName());
        menuEntity.setMenuCode(editMenuBO.getMenuCode());
        return menuEntity;
    }
}

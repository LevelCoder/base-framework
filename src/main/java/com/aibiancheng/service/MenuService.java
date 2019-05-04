package com.aibiancheng.service;

import com.aibiancheng.model.bo.menu.AddMenuBO;
import com.aibiancheng.model.bo.menu.EditMenuBO;
import com.aibiancheng.model.bo.menu.FindMenuBo;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.resp.RespJsonPageData;

/**
 * 描述:菜单service
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public interface MenuService {

    /**
     * 新增菜单
     * @param addMenuBO
     * @return
     */
    RespJson addMenu(AddMenuBO addMenuBO) ;

    /**
     * 修改菜单
     * @param editMenuBO
     * @return
     */
    RespJson editMenu(EditMenuBO editMenuBO) ;

    /**
     * 变更菜单状态 启用/禁用
     * @param menuId
     * @param menuState
     * @return
     */
    RespJson changeMenu(Long menuId, byte menuState) ;

    /**
     * 删除菜单
     * @param menuId
     * @return
     */
    RespJson deleteMenu(Long menuId) ;

    /**
     * 查看菜单详情
     * @param menuId
     * @return
     */
    RespJsonData viewMenuDetail(Long menuId) ;

    /**
     * 查看菜单列表
     * @param findMenuBo
     * @return
     */
    RespJsonPageData viewMenuList(FindMenuBo findMenuBo) ;
}

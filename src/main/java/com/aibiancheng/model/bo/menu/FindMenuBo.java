package com.aibiancheng.model.bo.menu;

import com.alibaba.fastjson.JSON;

/**
 * 描述:搜索菜单
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/26
 */
public class FindMenuBo {

    /** 菜单类别 catalog(目录) menu(菜单) */
    private Byte menuType;

    /** 菜单状态 1.启用 2.停用*/
    private Byte menuState;

    /** 初始页 默认为1 */
    private Integer currentPage;

    /** 每页条数 默认为 10 */
    private Integer pageSize;

    public Byte getMenuType() {
        return menuType;
    }

    public void setMenuType(Byte menuType) {
        this.menuType = menuType;
    }

    public Byte getMenuState() {
        return menuState;
    }

    public void setMenuState(Byte menuState) {
        this.menuState = menuState;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

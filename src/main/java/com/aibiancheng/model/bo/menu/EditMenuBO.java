package com.aibiancheng.model.bo.menu;

/**
 * 描述:修改菜单
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/26
 */
public class EditMenuBO {

    /** 菜单id */
    private Long id;

    /** 菜单名称 */
    private String menuName;

    /** 菜单路径 */
    private String menuUrl;

    /** 菜单图标 */
    private String menuIcon;

    /** 菜单父id */
    private Long menuParentId;

    /** 菜单状态 1.启用 2.停用*/
    private Byte menuState;

    /** 菜单描述 */
    private String menuDesc;

    /** 菜单排序 */
    private Integer menuSort;

    /** 菜单类别 catalog(目录) menu(菜单) */
    private String menuType;

    /** 资源标识 权限标识*/
    private String menuCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Long getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Long menuParentId) {
        this.menuParentId = menuParentId;
    }

    public Byte getMenuState() {
        return menuState;
    }

    public void setMenuState(Byte menuState) {
        this.menuState = menuState;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }
}

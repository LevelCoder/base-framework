package com.aibiancheng.model.bo.element;

/**
 * 描述:新增元素
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/2
 */
public class AddElementBO {
    /** 元素名称 */
    private String elementName;

    /** 元素标识 用于权限处理*/
    private String elementCode;

    /** 元素地址 */
    private String elementUrl;

    /** 元素类型 menu /button */
    private String elementType;

    /** 请求方法 GET POST 由于采用json作为传输对象 采用GET POST 足够 */
    private String elementMethod;

    /** 菜单id */
    private Long menuId;

    /** 元素描述 */
    private String elementDesc;

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementCode() {
        return elementCode;
    }

    public void setElementCode(String elementCode) {
        this.elementCode = elementCode;
    }

    public String getElementUrl() {
        return elementUrl;
    }

    public void setElementUrl(String elementUrl) {
        this.elementUrl = elementUrl;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getElementMethod() {
        return elementMethod;
    }

    public void setElementMethod(String elementMethod) {
        this.elementMethod = elementMethod;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getElementDesc() {
        return elementDesc;
    }

    public void setElementDesc(String elementDesc) {
        this.elementDesc = elementDesc;
    }
}

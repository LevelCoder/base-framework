package com.aibiancheng.model.dto.bind;

/**
 * 描述:角色元素
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/26
 */
public class RoleResourceElementDTO {

    /** 主键id */
    private Long elementId;

    /** 元素名称 */
    private String elementName;

    /** 元素标识 */
    private String elementCode;

    /** 元素地址 */
    private String elementUrl;

    /** 元素类型 menu /button */
    private String elementType;

    /** 元素描述 */
    private String elementDesc;

    /** 元素选中状态*/
    private int elementCheckState;

    public Long getElementId() {
        return elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

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

    public String getElementDesc() {
        return elementDesc;
    }

    public void setElementDesc(String elementDesc) {
        this.elementDesc = elementDesc;
    }

    public int getElementCheckState() {
        return elementCheckState;
    }

    public void setElementCheckState(int elementCheckState) {
        this.elementCheckState = elementCheckState;
    }
}

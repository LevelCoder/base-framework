package com.aibiancheng.extension;

import com.aibiancheng.entity.ElementEntity;
import com.aibiancheng.model.bo.element.AddElementBO;
import com.aibiancheng.model.bo.element.EditElementBO; /**
 * 描述:元素数据延展类
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/3
 */
public class ElementExtension {

    /**
     * 新增元素
     * @param addElementBO
     * @return
     */
    public static ElementEntity addElement(AddElementBO addElementBO) {
        ElementEntity elementEntity = new ElementEntity();
        elementEntity.setElementCode(addElementBO.getElementCode());
        elementEntity.setElementDesc(addElementBO.getElementDesc());
        elementEntity.setElementMethod(addElementBO.getElementMethod());
        elementEntity.setElementName(addElementBO.getElementName());
        elementEntity.setElementType(addElementBO.getElementType());
        elementEntity.setElementUrl(addElementBO.getElementUrl());
        elementEntity.setMenuId(addElementBO.getMenuId());
        return elementEntity;
    }

    /**
     * 修改元素
     * @param editElementBO
     * @return
     */
    public static ElementEntity editElement(EditElementBO editElementBO) {
        ElementEntity elementEntity = new ElementEntity();
        elementEntity.setId(editElementBO.getId());
        elementEntity.setElementCode(editElementBO.getElementCode());
        elementEntity.setElementDesc(editElementBO.getElementDesc());
        elementEntity.setElementMethod(editElementBO.getElementMethod());
        elementEntity.setElementName(editElementBO.getElementName());
        elementEntity.setElementType(editElementBO.getElementType());
        elementEntity.setElementUrl(editElementBO.getElementUrl());
        elementEntity.setMenuId(editElementBO.getMenuId());
        return elementEntity;
    }
}

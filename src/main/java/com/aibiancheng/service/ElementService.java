package com.aibiancheng.service;

import com.aibiancheng.model.bo.element.AddElementBO;
import com.aibiancheng.model.bo.element.EditElementBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;

/**
 * 描述:元素/按钮service
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public interface ElementService {

    /**
     * 新增元素
     * @param addElementBO
     * @return
     */
    RespJson addElement(AddElementBO addElementBO) ;

    /**
     * 修改元素
     * @param editElementBO
     * @return
     */
    RespJson editElement(EditElementBO editElementBO) ;

    /**
     * 删除元素
     * @param elementId
     * @return
     */
    RespJson deleteElement(Long elementId) ;

    /**
     * 查看元素详情
     * @param elementId
     * @return
     */
    RespJsonData viewElementDetail(Long elementId) ;
}

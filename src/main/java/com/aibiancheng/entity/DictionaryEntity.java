package com.aibiancheng.entity;

import java.io.Serializable;

/**
 * 描述:数据字典表
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public class DictionaryEntity implements Serializable {

    /** 主键id  */
    private Long id;

    /** 字典编码 */
    private String dictCode;

    /** 字典名称 */
    private String dictName;

    /** 字典类型 */
    private String dictType;

    /** 字典描述 */
    private String dictDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictDesc() {
        return dictDesc;
    }

    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc;
    }

    @Override
    public String toString() {
        return "DictionaryEntity{" +
                "id=" + id +
                ", dictCode='" + dictCode + '\'' +
                ", dictName='" + dictName + '\'' +
                ", dictType='" + dictType + '\'' +
                ", dictDesc='" + dictDesc + '\'' +
                '}';
    }
}

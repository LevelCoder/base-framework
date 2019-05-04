package com.aibiancheng.entity;

import java.io.Serializable;

/**
 * 描述:字典详情表
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public class DictionaryDetailEntity  implements Serializable {

    /** 主键id */
    private Long id;

    /** 数据字典id */
    private Long dictId;

    /** key */
    private String dictDataKey;

    /** value */
    private String dictDataValue;

    /** 排序 */
    private Integer dictDataSort;

    /** 描述 */
    private Byte dictDataState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getDictDataKey() {
        return dictDataKey;
    }

    public void setDictDataKey(String dictDataKey) {
        this.dictDataKey = dictDataKey;
    }

    public String getDictDataValue() {
        return dictDataValue;
    }

    public void setDictDataValue(String dictDataValue) {
        this.dictDataValue = dictDataValue;
    }

    public Integer getDictDataSort() {
        return dictDataSort;
    }

    public void setDictDataSort(Integer dictDataSort) {
        this.dictDataSort = dictDataSort;
    }

    public Byte getDictDataState() {
        return dictDataState;
    }

    public void setDictDataState(Byte dictDataState) {
        this.dictDataState = dictDataState;
    }

    @Override
    public String toString() {
        return "DictionaryDetailEntity{" +
                "id=" + id +
                ", dictId=" + dictId +
                ", dictDataKey='" + dictDataKey + '\'' +
                ", dictDataValue='" + dictDataValue + '\'' +
                ", dictDataSort=" + dictDataSort +
                ", dictDataState=" + dictDataState +
                '}';
    }
}

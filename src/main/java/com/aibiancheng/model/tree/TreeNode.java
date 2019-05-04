package com.aibiancheng.model.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:树节点.所有树都继承此类获取节点id
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/27
 */
public abstract class TreeNode {

    protected Long id;

    protected Long parentId;

    List<TreeNode> children = new ArrayList<TreeNode>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    /**
     * 追加子节点
     * @param node
     */
    public void add(TreeNode node){
        children.add(node);
    }
}

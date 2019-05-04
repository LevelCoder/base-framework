package com.aibiancheng.model.tree;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:权限树
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/27
 */
public class AuthorityMenuTree extends TreeNode implements Serializable {

    /** 名称 */
    String text;

    /** 图标 */
    String icon;

    /** 菜单 */
    List<AuthorityMenuTree> nodes = new ArrayList<AuthorityMenuTree>();

    /**
     * 空构造器
     */
    public AuthorityMenuTree() { }


    public AuthorityMenuTree(String text, List<AuthorityMenuTree> nodes) {
        this.text = text;
        this.nodes = nodes;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<AuthorityMenuTree> getNodes() {
        return nodes;
    }

    public void setNodes(List<AuthorityMenuTree> nodes) {
        this.nodes = nodes;
    }

    @Override
    public void setChildren(List<TreeNode> children) {
        super.setChildren(children);
        nodes = new ArrayList<AuthorityMenuTree>();
    }

    @Override
    public void add(TreeNode node) {
        super.add(node);
        AuthorityMenuTree n = new AuthorityMenuTree();
        BeanUtils.copyProperties(node,n);
        nodes.add(n);
    }
}

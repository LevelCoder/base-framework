package com.aibiancheng.model.bo.user;

/**
 * 描述:修改密码
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/3
 */
public class ModifyUserPassWordBO {

    /** 用户id */
    private Long userId;

    /** 老密码 */
    private String oldPassWord;

    /** 新密码 */
    private String newPassWord;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOldPassWord() {
        return oldPassWord;
    }

    public void setOldPassWord(String oldPassWord) {
        this.oldPassWord = oldPassWord;
    }

    public String getNewPassWord() {
        return newPassWord;
    }

    public void setNewPassWord(String newPassWord) {
        this.newPassWord = newPassWord;
    }
}

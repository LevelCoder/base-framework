package com.aibiancheng.model.bo.user;

/**
 * 描述:用户密码找回
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/3
 */
public class BackUserPassWordBO {

    /** 手机号找回 */
    private String userPhone;

    /** 邮箱找回 */
    private String userEmail;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}

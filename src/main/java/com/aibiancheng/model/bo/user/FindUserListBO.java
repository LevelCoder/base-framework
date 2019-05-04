package com.aibiancheng.model.bo.user;

/**
 * 描述:查看用户列表
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/22
 */
public class FindUserListBO {

    /** 用户状态 */
    private Byte userState;

    /** 用户类型 */
    private Byte userType;

    /** 用户电话 */
    private String userPhone;

    /** 用户邮箱 */
    private String userEmail;

    /** 初始页 默认为1 */
    private Integer currentPage;

    /** 每页条数 默认为 10 */
    private Integer pageSize;

    public Byte getUserState() {
        return userState;
    }

    public void setUserState(Byte userState) {
        this.userState = userState;
    }

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

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

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage == null ? 1 : currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize == null ? 10 : pageSize ;
    }

}

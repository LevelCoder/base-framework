package com.aibiancheng.entity;

import java.io.Serializable;

/**
 * 描述:用户表
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
public class UserEntity implements Serializable {
    /** 主键id  */
    private Long id;

    /** 昵称 */
    private String nickName;

    /** 用户邮箱 */
    private String userEmail;

    /** 用户手机号 */
    private String userPhone;

    /** 用户地址 */
    private String userAddress;

    /** 用户生日 */
    private String userBirth;

    /** 用户头像 */
    private String userPhoto;

    /** 用户状态 1.启用 2.禁用 3.锁定(用户多次输入密码错误后锁定 可通过缓存redis进行处理) */
    private Byte userState;

    /** 用户类型 1.系统用户 2.会员用户 3.平台商户 4.供货厂商 */
    private Byte userType;

    /** 省份编号 */
    private Long userProvinceCode;

    /** 城市编号 */
    private Long userCityCode;

    /** 区域编号 */
    private Long userAreaCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

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

    public Long getUserProvinceCode() {
        return userProvinceCode;
    }

    public void setUserProvinceCode(Long userProvinceCode) {
        this.userProvinceCode = userProvinceCode;
    }

    public Long getUserCityCode() {
        return userCityCode;
    }

    public void setUserCityCode(Long userCityCode) {
        this.userCityCode = userCityCode;
    }

    public Long getUserAreaCode() {
        return userAreaCode;
    }

    public void setUserAreaCode(Long userAreaCode) {
        this.userAreaCode = userAreaCode;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", userState=" + userState +
                ", userType=" + userType +
                ", userProvinceCode=" + userProvinceCode +
                ", userCityCode=" + userCityCode +
                ", userAreaCode=" + userAreaCode +
                '}';
    }
}

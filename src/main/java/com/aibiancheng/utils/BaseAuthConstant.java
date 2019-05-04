package com.aibiancheng.utils;

/**
 * 描述:基础全局变量
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/25
 */
public class BaseAuthConstant {

    /**
     * 系统返回变量
     */
    public class responseCode{

        /** 正确返回值 */
        public static final String SUCCESS_CODE = "200";

        /** 错误返回值 */
        public static final String FAIL_CODE = "500";
    }

    /**
     * 系统返回变量消息内容
     */
    public class responseMessage{

        /** 正确返回值 */
        public static final String SUCCESS_MESSAGE = "成功";

        /** 错误返回值 */
        public static final String FAIL_MESSAGE = "未知异常,请联系管理员";

        /** 参数为空,请重新录入 */
        public static final String PARAMS_IS_EMPTY = "参数为空,请重新录入";

        /** 没有权限 */
        public static final String DOES_NOT_HAVE_PERMISSION = "没有权限";
    }


    /**
     * 系统返回用户相关信息
     */
    public class responseUserMessage{

        public static final String USERNAME_OR_PASSWORD_FAIL = "用户名或密码不正确";

        public static final String ACCOUNT_IS_LOCKED = "账号已被锁定,请联系管理员";

        public static final String PHONE_IS_FAIL = "手机号格式不正确,请重新录入";

        public static final String USER_DOES_NOT_EXIST = "用户不存在,请联系管理员";

        public static final String PASS_WORD_IS_IDENTICAL = "新密码和原密码相同,请重新录入";

        public static final String USER_NAME_EXIST = "用户名已存在,请重新录入";

        public static final String USER_EMAIL_EXIST = "邮箱已存在,请重新录入";

        public static final String USER_PHONE_EXIST = "手机号已存在,请重新录入";
    }


    /** 常用变量 */
    public class variable{

        /** 系统角色 */
        public static final String ROLE_TYPE_SYSTEM = "system";

        /** 业务角色 */
        public static final String ROLE_TYPE_BUSSINESS = "bussiness";


        public static final long ADMIN = 1L;
    }


}

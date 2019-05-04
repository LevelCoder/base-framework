package com.aibiancheng.exception;

/**
 * 描述:自定义异常:在做事物回滚的时候因为继承RuntimeException所以会回滚
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/26
 */
public class CustomException extends RuntimeException{


    private static final long serialVersionUID = 1L;

    /** 异常错误代码 默认错误码为500 */
    private String errorCode = "500";

    /** 异常错误信息 */
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    /**
     * 只传递错误信息
     * @param errorMessage
     */
    public CustomException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    /**
     * 传递错误码和错误信息
     * @param errorCode
     * @param errorMessage
     */
    public CustomException(String errorCode,String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    /**
     * 传递错误参数 和异常 信息
     * @param errorMessage
     * @param e
     */
    public CustomException(String errorMessage, Throwable e) {
        super(errorMessage, e);
        this.errorMessage = errorMessage;
    }


    /**
     *
     * @param errorCode
     * @param errorMessage
     * @param e
     */
    public CustomException(String errorCode,String errorMessage, Throwable e) {
        super(errorMessage, e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}

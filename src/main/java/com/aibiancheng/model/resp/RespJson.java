package com.aibiancheng.model.resp;

import org.apache.commons.httpclient.HttpStatus;

/**
 * 返回结果基础类
 */
public class RespJson {

    private String responseCode;

    private String responseMessage;

    public RespJson(){}

    public RespJson(String responseCode ,String responseMessage){
        this.responseCode = responseCode;
        this.responseMessage =responseMessage;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

}

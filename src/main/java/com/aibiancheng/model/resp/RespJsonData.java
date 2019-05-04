package com.aibiancheng.model.resp;

/**
 * 返回参数不带分页
 */
public class RespJsonData extends RespJson {

    private Object responseData;

    public RespJsonData(){}

    public RespJsonData(Object responseData,String responseCode ,String responseMessage){
        super(responseCode,responseMessage);
        this.responseData = responseData;
    }

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }
}

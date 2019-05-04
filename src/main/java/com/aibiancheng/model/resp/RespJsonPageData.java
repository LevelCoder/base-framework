package com.aibiancheng.model.resp;

/**
 * 返回参数,带分页
 */
public class RespJsonPageData extends RespJson {

    private Object responseData;

    private int total;

    public RespJsonPageData(Object responseData , int total ,String responseCode ,String responseMessage){
        super(responseCode,responseMessage);
        this.responseData = responseData;
        this.total = total;
    }

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

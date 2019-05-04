package com.aibiancheng.exception;

import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.utils.BaseAuthConstant;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 描述:统一异常处理
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/26
 */

@RestControllerAdvice
public class ExceptionAdvice {

    /** 引入日志 */
    private static Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);


    /**
     * 处理Exception异常 非自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public RespJson handleException(Exception e){
        logger.error(e.getMessage(), e);
        if(e instanceof UnauthorizedException){
            return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,BaseAuthConstant.responseMessage.DOES_NOT_HAVE_PERMISSION);
        }

        return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,BaseAuthConstant.responseMessage.FAIL_MESSAGE);
    }


    /**
     * 处理自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public RespJson handleException(CustomException e){
        logger.error(e.getMessage(), e);
        return new RespJson(e.getErrorCode(),e.getErrorMessage());
    }

}

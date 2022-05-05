package com.gu.drools.config.exception;

import lombok.Getter;

/**
 * @ClassName: BusinessException
 * @Description:  业务异常，统一抛出
 * @author: guhuan
 */
@Getter
public class BusinessException extends RuntimeException {

    /*** 错误编码 ***/
    private Integer errorCode;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}

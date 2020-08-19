package dev.tioachan.framework.exception;

import dev.tioachan.framework.model.response.ResultCode;

public class ExceptionCast {
    //使用此静态方法抛出自定义异常
    public static void cast(ResultCode resultCode) {
        throw new CustomException(resultCode);
    }
}
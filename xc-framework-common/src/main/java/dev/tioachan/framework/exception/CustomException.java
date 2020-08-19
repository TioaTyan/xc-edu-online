package dev.tioachan.framework.exception;

import dev.tioachan.framework.model.response.ResultCode;

//自定义异常
//继承RuntimeException，可以直接抛出该异常且不需在方法名之后throw
public class CustomException extends RuntimeException {
	private ResultCode resultCode;

	public ResultCode getResultCode() {
		return this.resultCode;
	}

	public CustomException(ResultCode resultCode) {
		super("错误代码：" + resultCode.code() + "，错误信息：" + resultCode.message());
		this.resultCode = resultCode;
	}
}

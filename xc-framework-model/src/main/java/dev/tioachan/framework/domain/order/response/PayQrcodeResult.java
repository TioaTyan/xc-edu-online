package dev.tioachan.framework.domain.order.response;

import dev.tioachan.framework.model.response.ResponseResult;
import dev.tioachan.framework.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;

/**
 * Created by mrt on 2018/3/27.
 */
@Data
@ToString
public class PayQrcodeResult extends ResponseResult {
	private String codeUrl;
	private Float money;
	private String orderNumber;
	public PayQrcodeResult(ResultCode resultCode) {
		super(resultCode);
	}

}

package dev.tioachan.framework.domain.order.response;

import dev.tioachan.framework.domain.order.XcOrdersPay;
import dev.tioachan.framework.model.response.ResponseResult;
import dev.tioachan.framework.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;

/**
 * Created by mrt on 2018/3/27.
 */
@Data
@ToString
public class PayOrderResult extends ResponseResult {
	private XcOrdersPay xcOrdersPay;
	private String orderNumber;
	//当tradeState为NOTPAY（未支付）时显示支付二维码
	private String codeUrl;
	private Float money;

	public PayOrderResult(ResultCode resultCode) {
		super(resultCode);
	}
	public PayOrderResult(ResultCode resultCode, XcOrdersPay xcOrdersPay) {
		super(resultCode);
		this.xcOrdersPay = xcOrdersPay;
	}


}

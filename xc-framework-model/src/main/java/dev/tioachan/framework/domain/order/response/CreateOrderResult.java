package dev.tioachan.framework.domain.order.response;

import dev.tioachan.framework.domain.order.XcOrders;
import dev.tioachan.framework.model.response.ResponseResult;
import dev.tioachan.framework.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;

/**
 * Created by mrt on 2018/3/26.
 */
@Data
@ToString
public class CreateOrderResult extends ResponseResult {
	private XcOrders xcOrders;

	public CreateOrderResult(ResultCode resultCode, XcOrders xcOrders) {
		super(resultCode);
		this.xcOrders = xcOrders;
	}


}

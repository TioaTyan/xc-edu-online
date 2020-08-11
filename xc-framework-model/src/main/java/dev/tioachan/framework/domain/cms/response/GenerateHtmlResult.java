package dev.tioachan.framework.domain.cms.response;

import dev.tioachan.framework.model.response.ResponseResult;
import dev.tioachan.framework.model.response.ResultCode;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 */
@Data
public class GenerateHtmlResult extends ResponseResult {
	String html;

	public GenerateHtmlResult(ResultCode resultCode, String html) {
		super(resultCode);
		this.html = html;
	}
}

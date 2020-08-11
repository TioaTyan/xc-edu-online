package dev.tioachan.framework.domain.ucenter.response;

import dev.tioachan.framework.model.response.ResponseResult;
import dev.tioachan.framework.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by mrt on 2018/5/21.
 */
@Data
@ToString
@NoArgsConstructor
public class LoginResult extends ResponseResult {
	private String token;

	public LoginResult(ResultCode resultCode, String token) {
		super(resultCode);
		this.token = token;
	}
}

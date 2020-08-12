package dev.tioachan.framework.domain.cms.response;

import dev.tioachan.framework.model.response.ResponseResult;
import dev.tioachan.framework.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by admin on 2018/3/5.
 */
@Data
@ToString
@NoArgsConstructor
public class CoursePreviewResult extends ResponseResult {
	String url;

	public CoursePreviewResult(ResultCode resultCode, String url) {
		super(resultCode);
		this.url = url;
	}
}
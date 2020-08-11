package dev.tioachan.framework.domain.course.response;

import dev.tioachan.framework.model.response.ResponseResult;
import dev.tioachan.framework.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;

/**
 * Created by mrt on 2018/3/20.
 */
@Data
@ToString
public class DeleteCourseResult extends ResponseResult {
	private String courseid;

	public DeleteCourseResult(ResultCode resultCode, String courseId) {
		super(resultCode);
		this.courseid = courseid;
	}

}

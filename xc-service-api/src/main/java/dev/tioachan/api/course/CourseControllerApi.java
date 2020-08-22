package dev.tioachan.api.course;

import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.domain.course.CoursePic;
import dev.tioachan.framework.domain.course.request.CourseListRequest;
import dev.tioachan.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;

@Api(value="课程管理接口")
public interface CourseControllerApi {
	@ApiOperation("分页查询页面列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),
			@ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int")
	})
	QueryResponseResult findCourseList(Integer page, Integer size,  CourseListRequest courseListRequest);

	@ApiOperation("课程图片")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "courseId", value = "课程id", required = true, paramType = "path", dataType = "String")
	})
	CoursePic findCoursePic(String courseId);
}

package dev.tioachan.api.course;

import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.domain.course.CourseBase;
import dev.tioachan.framework.domain.course.CourseMarket;
import dev.tioachan.framework.domain.course.CoursePic;
import dev.tioachan.framework.domain.course.request.CourseListRequest;
import dev.tioachan.framework.domain.course.response.AddCourseResult;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Api(value="课程管理接口")
public interface CourseControllerApi {
	@ApiOperation("分页查询页面列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),
			@ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int")
	})
	QueryResponseResult findCourseList(Integer page, Integer size,  CourseListRequest courseListRequest);


	@ApiOperation("根据课程Id获取课程基本信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "courseId", value = "课程id", required = true, paramType = "path", dataType = "String")
	})
	CourseBase getCourseBaseById(@PathVariable("courseId") String courseId);

	@ApiOperation("添加课程基础信息")
	public AddCourseResult addCourseBase(CourseBase courseBase);

	@ApiOperation("更新课程基础信息")
	public ResponseResult updateCourseBase(String id,CourseBase courseBase);

	@ApiOperation("课程图片")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "courseId", value = "课程id", required = true, paramType = "path", dataType = "String")
	})
	CoursePic findCoursePic(String courseId);

	@ApiOperation("添加课程图片")
	public ResponseResult addCoursePic(String courseId,String pictureId);

	@ApiOperation("删除课程图片")
	public ResponseResult deleteCoursePic(String courseId);

//	AddCourseResult addCourseBase(@RequestBody CourseBase courseBase) ;
//
//	ResponseResult updateCourseBase(@PathVariable("id") String id, @RequestBody CourseBase courseBase);

	@ApiOperation("获取课程营销信息")
	CourseMarket getCourseMarketById(String courseId);
	@ApiOperation("更新课程营销信息")
	ResponseResult updateCourseMarket(String id, CourseMarket courseMarket);
}

package dev.tioachan.manage_course.service;

import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.domain.course.CourseBase;
import dev.tioachan.framework.domain.course.CoursePic;
import dev.tioachan.framework.domain.course.request.CourseListRequest;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.framework.model.response.ResponseResult;

public interface CourseService {
	QueryResponseResult findCourseList(Integer page, Integer size,  CourseListRequest courseListRequest);

	CoursePic findCoursePic(String courseId);

	CourseBase getCourseBaseById(String courseId);

	ResponseResult addCoursePic(String courseId, String pictureId);

	ResponseResult deleteCoursePic(String courseId);
}

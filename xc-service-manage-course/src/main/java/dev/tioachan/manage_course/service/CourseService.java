package dev.tioachan.manage_course.service;

import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.domain.course.request.CourseListRequest;
import dev.tioachan.framework.model.response.QueryResponseResult;

public interface CourseService {
	QueryResponseResult findCourseList(Integer page, Integer size,  CourseListRequest courseListRequest);
}

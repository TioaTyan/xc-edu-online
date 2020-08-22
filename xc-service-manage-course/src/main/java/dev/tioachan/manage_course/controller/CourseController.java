package dev.tioachan.manage_course.controller;

import dev.tioachan.api.course.CourseControllerApi;
import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.domain.course.CoursePic;
import dev.tioachan.framework.domain.course.request.CourseListRequest;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.manage_course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course/coursebase")
public class CourseController implements CourseControllerApi {

	@Autowired
	CourseService courseService;

	@Override
	@GetMapping("/list/{page}/{size}/")
	public QueryResponseResult findCourseList(@PathVariable("page") Integer page, @PathVariable("size") Integer size,  CourseListRequest courseListRequest) {
		return courseService.findCourseList(page,size,courseListRequest);
	}

	@Override
	@GetMapping("/coursePic/list/{courseId}")
	public CoursePic findCoursePic(@PathVariable("courseId") String courseId) {
		return courseService.findCoursePic(courseId);
	}
}

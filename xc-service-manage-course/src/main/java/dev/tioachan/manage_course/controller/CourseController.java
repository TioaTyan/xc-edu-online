package dev.tioachan.manage_course.controller;

import dev.tioachan.api.course.CourseControllerApi;
import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.domain.course.CourseBase;
import dev.tioachan.framework.domain.course.CourseMarket;
import dev.tioachan.framework.domain.course.CoursePic;
import dev.tioachan.framework.domain.course.request.CourseListRequest;
import dev.tioachan.framework.domain.course.response.AddCourseResult;
import dev.tioachan.framework.model.response.CommonCode;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.framework.model.response.ResponseResult;
import dev.tioachan.manage_course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.*;

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

	@Override
	@PostMapping("/coursePic/{courseId}")
	public ResponseResult addCoursePic(@PathVariable("courseId")String courseId, String pictureId) {
		return courseService.addCoursePic(courseId,pictureId);
	}

	@Override
	@DeleteMapping("/coursePic/{courseId}")
	public ResponseResult deleteCoursePic(@PathVariable("courseId")String courseId) {
		return courseService.deleteCoursePic(courseId);
	}

	@Override
	@GetMapping("/courseMarket/{courseId}")
	public CourseMarket getCourseMarketById(@PathVariable("courseId") String courseId) {
		return courseService.getCourseMarketById(courseId);
	}

	@Override
	@PostMapping("/courseMarket/update/{id}")
	public ResponseResult updateCourseMarket(@PathVariable("id") String id, @RequestBody CourseMarket
			courseMarket) {
		CourseMarket courseMarket_u = courseService.updateCourseMarket(id, courseMarket);
		if(courseMarket_u!=null){
			return new ResponseResult(CommonCode.SUCCESS);
		}else{
			return new ResponseResult(CommonCode.FAIL);
		}
	}


	@Override
	@GetMapping("/{courseId}")
	public CourseBase getCourseBaseById(@PathVariable("courseId") String courseId) {
		return courseService.getCourseBaseById(courseId);
	}

	@Override
	public AddCourseResult addCourseBase(CourseBase courseBase) {
		return null;
	}

	@Override
	public ResponseResult updateCourseBase(String id, CourseBase courseBase) {
		return null;
	}


}

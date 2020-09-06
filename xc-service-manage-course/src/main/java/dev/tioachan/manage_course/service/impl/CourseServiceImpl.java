package dev.tioachan.manage_course.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import dev.tioachan.framework.domain.course.CourseBase;
import dev.tioachan.framework.domain.course.CourseMarket;
import dev.tioachan.framework.domain.course.CoursePic;
import dev.tioachan.framework.domain.course.ext.CourseInfo;
import dev.tioachan.framework.domain.course.request.CourseListRequest;
import dev.tioachan.framework.model.response.CommonCode;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.framework.model.response.QueryResult;
import dev.tioachan.framework.model.response.ResponseResult;
import dev.tioachan.manage_course.dao.CourseBaseRepository;
import dev.tioachan.manage_course.dao.CourseDao;
import dev.tioachan.manage_course.dao.CourseMarketRepository;
import dev.tioachan.manage_course.dao.CoursePicRepository;
import dev.tioachan.manage_course.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;

	@Autowired
	CoursePicRepository coursePicRepository;

	@Autowired
	CourseBaseRepository courseBaseRepository;

	@Autowired
	CourseMarketRepository courseMarketRepository;

	@Override
	public QueryResponseResult findCourseList(Integer page, Integer size, CourseListRequest courseListRequest) {
		if (courseListRequest == null) {
			courseListRequest = new CourseListRequest();
		}

		if (page <= 0) {
			page = 0;
		}
		if (size <= 0) {
			size = 20;
		}
		//设置分页参数
		PageHelper.startPage(page, size);
		//分页查询
		Page<CourseInfo> courseListPage = courseDao.findCourseListPage(courseListRequest);
		//查询列表
		List<CourseInfo> list = courseListPage.getResult();
		//总记录数
		long total = courseListPage.getTotal();
		//查询结果集
		QueryResult<CourseInfo> courseInfoQueryResult = new QueryResult<CourseInfo>();
		courseInfoQueryResult.setList(list);
		courseInfoQueryResult.setTotal(total);
		return new QueryResponseResult(CommonCode.SUCCESS, courseInfoQueryResult);
	}

	@Override
	//查询课程图片
	public CoursePic findCoursePic(String courseId) {
		Optional<CoursePic> optional = coursePicRepository.findById(courseId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public CourseBase getCourseBaseById(String courseId) {
		Optional<CourseBase> optional = courseBaseRepository.findById(courseId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public ResponseResult addCoursePic(String courseId, String pictureId) {
		//查询课程图片
		Optional<CoursePic> picOptional = coursePicRepository.findById(courseId);
		CoursePic coursePic = null;
		if (picOptional.isPresent()) {
			coursePic = picOptional.get();
		}
		//没有课程图片则新建对象
		if (coursePic == null) {
			coursePic = new CoursePic();
		}
		coursePic.setCourseid(courseId);
		coursePic.setPic(pictureId);
		//保存课程图片
		coursePicRepository.save(coursePic);
		return new ResponseResult(CommonCode.SUCCESS);
	}

	//https://www.cnblogs.com/sxdcgaq8080/p/8984140.html
	@Override
	@Modifying
	@Transactional
	public ResponseResult deleteCoursePic(String courseId) {
//		执行删除，返回1表示删除成功，返回0表示删除失败
		long result = coursePicRepository.deleteByCourseid(courseId);
		if (result > 0) {
			return new ResponseResult(CommonCode.SUCCESS);
		}
		return new ResponseResult(CommonCode.FAIL);
	}

	@Override
	public CourseMarket getCourseMarketById(String courseId) {
		Optional<CourseMarket> optional = courseMarketRepository.findById(courseId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public CourseMarket updateCourseMarket(String id, CourseMarket courseMarket) {
		CourseMarket one = this.getCourseMarketById(id);
		if (one != null) {
			one.setCharge(courseMarket.getCharge());
			one.setStartTime(courseMarket.getStartTime());//课程有效期，开始时间
			one.setEndTime(courseMarket.getEndTime());//课程有效期，结束时间
			one.setPrice(courseMarket.getPrice());
			one.setQq(courseMarket.getQq());
			one.setValid(courseMarket.getValid());
			courseMarketRepository.save(one);
		} else {
			//添加课程营销信息
			one = new CourseMarket();
			BeanUtils.copyProperties(courseMarket, one);
			//设置课程id
			one.setId(id);
			courseMarketRepository.save(one);
		}
		return one;
	}

}

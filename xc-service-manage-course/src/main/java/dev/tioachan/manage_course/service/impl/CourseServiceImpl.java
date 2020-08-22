package dev.tioachan.manage_course.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import dev.tioachan.framework.domain.cms.CmsPage;
import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.domain.course.ext.CourseInfo;
import dev.tioachan.framework.domain.course.request.CourseListRequest;
import dev.tioachan.framework.model.response.CommonCode;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.framework.model.response.QueryResult;
import dev.tioachan.manage_course.dao.CourseDao;
import dev.tioachan.manage_course.service.CourseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;

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
}

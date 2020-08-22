package dev.tioachan.manage_course.dao;

import com.github.pagehelper.Page;
import dev.tioachan.framework.domain.course.ext.CourseInfo;
import dev.tioachan.framework.domain.course.request.CourseListRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface CourseDao {
	Page<CourseInfo> findCourseListPage(CourseListRequest courseListRequest);
}

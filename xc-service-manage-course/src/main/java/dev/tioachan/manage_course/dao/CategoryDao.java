package dev.tioachan.manage_course.dao;

import dev.tioachan.framework.domain.course.ext.CategoryNode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao {
	CategoryNode findList();

}

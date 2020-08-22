package dev.tioachan.manage_course.service.impl;

import dev.tioachan.framework.domain.course.ext.CategoryNode;
import dev.tioachan.manage_course.dao.CategoryDao;
import dev.tioachan.manage_course.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao;

	@Override
	public CategoryNode findList() {
		return categoryDao.findList();
	}
}

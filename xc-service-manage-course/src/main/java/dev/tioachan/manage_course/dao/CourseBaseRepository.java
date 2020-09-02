package dev.tioachan.manage_course.dao;

import dev.tioachan.framework.domain.course.CourseBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseBaseRepository extends JpaRepository<CourseBase,String> {
}

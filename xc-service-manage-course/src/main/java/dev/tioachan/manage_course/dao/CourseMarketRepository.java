package dev.tioachan.manage_course.dao;

import dev.tioachan.framework.domain.course.CourseMarket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMarketRepository extends JpaRepository<CourseMarket, String> {
}

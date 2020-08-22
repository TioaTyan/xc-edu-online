package dev.tioachan.manage_course.dao;

import dev.tioachan.framework.domain.course.CoursePic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoursePicRepository extends JpaRepository<CoursePic,String> {
}

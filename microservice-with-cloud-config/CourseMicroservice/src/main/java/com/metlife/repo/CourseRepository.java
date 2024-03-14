package com.metlife.repo;

import com.metlife.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,Long> {

    List<Course> getByAuthorId(@Param("authorId") Long authorId);

}

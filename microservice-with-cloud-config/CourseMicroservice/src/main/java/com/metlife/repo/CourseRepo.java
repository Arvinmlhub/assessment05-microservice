package com.metlife.repo;

import com.metlife.entity.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends PagingAndSortingRepository<Course, Long> {
}

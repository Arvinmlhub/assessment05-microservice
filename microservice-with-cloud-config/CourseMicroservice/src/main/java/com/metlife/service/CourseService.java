package com.metlife.service;

import com.metlife.CourseDao;
import com.metlife.dto.CourseDto;

import java.util.Map;

public interface CourseService {

    CourseDto getCourses(int page , int size);
    Map<String, String> saveCourse(CourseDao courseDao);

    Map<String, String> updateCourse(CourseDao courseDao, Long courseId);

    Map<String, String> deleteCourse(Long courseId);
}

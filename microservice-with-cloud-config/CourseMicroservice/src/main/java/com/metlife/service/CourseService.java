package com.metlife.service;

import com.metlife.CourseDao;
import com.metlife.dto.CourseDto;
import com.metlife.entity.Author;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

public interface CourseService {

    CourseDto getCourses(int page , int size);
    Map<String, String> saveCourse(CourseDao courseDao);

    Map<String, String> updateCourse(CourseDao courseDao, Long courseId);

    Map<String, String> deleteCourse(Long courseId);


    Map<String, Object> getAuthorsById(Long authorId);

    public Map<String, Object> getAuthors(int page, int size);
}

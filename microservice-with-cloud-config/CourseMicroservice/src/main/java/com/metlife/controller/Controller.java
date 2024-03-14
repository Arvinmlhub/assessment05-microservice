package com.metlife.controller;

import com.metlife.CourseDao;
import com.metlife.dto.CourseDto;
import com.metlife.entity.Author;
import com.metlife.repo.CourseRepo;
import com.metlife.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/courses")
@ControllerAdvice
public class Controller {


    @Autowired
    private CourseService courseService;


    @GetMapping
    public CourseDto getCourses(@RequestParam(defaultValue = "0",required = false) int page,
                                @RequestParam(defaultValue = "10", required = false) int size){
        return courseService.getCourses(page,size);
    }

    @PostMapping
    public Map<String, String> saveCourse(@RequestBody CourseDao courseDao){
        return courseService.saveCourse(courseDao);
    }

    @PutMapping("/{courseId}")
    public Map<String, String> updateCourse(@RequestBody CourseDao courseDao, @PathVariable Long courseId){
        return courseService.updateCourse(courseDao,courseId);
    }

    @DeleteMapping("/{courseId}")
    public Map<String, String> deleteCourse(@PathVariable Long courseId){
        return courseService.deleteCourse(courseId);
    }

    @GetMapping("/getAllCourses/author/{authorId}")
    public Map<String, Object> getAuthorsById(@PathVariable  Long authorId){

        return courseService.getAuthorsById(authorId);
    }

    @GetMapping("/authors")
    public  Map<String, Object> getAuthors(@RequestParam(defaultValue = "0", required = false)
                                           int page, @RequestParam(defaultValue = "10", required = false) int size){
        return courseService.getAuthors(page, size)
;
    }









}

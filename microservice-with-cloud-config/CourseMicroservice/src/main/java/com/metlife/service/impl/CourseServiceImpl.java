package com.metlife.service.impl;

import com.metlife.CourseDao;
import com.metlife.dto.CourseDto;
import com.metlife.entity.Author;
import com.metlife.entity.Course;
import com.metlife.proxy.AuthorProxy;
import com.metlife.repo.CourseRepo;
import com.metlife.repo.CourseRepository;
import com.metlife.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {


    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private CourseRepository courseRepository;


    @Autowired
    private AuthorProxy authorProxy;
    public CourseDto getCourses(int page , int size){
        CourseDto courseDto=new CourseDto();

        try{
            Page<Course> courses= courseRepo.findAll(PageRequest.of(page,size));
            courseDto.setCount(courses.getTotalElements());
            courseDto.setCourseList(courses.getContent());

        }catch (Exception e){
            log.error("Exception occurred while getting courses.. ");
        }
        return courseDto;



    }

    public Map<String, String> saveCourse(CourseDao courseDao){
        Map<String, String>  resultMap=new HashMap<>();
//
        try {
            if (Objects.nonNull(courseDao)){
                Course course=new Course();
                BeanUtils.copyProperties(courseDao,course);

                course=courseRepository.save(course);
                resultMap.put("courseId",course.getCourseId().toString());
            }

            resultMap.put("status", "success");
        }catch (Exception e){
            log.error("Exception occurred while save the data...", e.getMessage());
            resultMap.put("status", "exception");
        }
        return resultMap;

    }

    public Map<String, String> updateCourse(CourseDao courseDao, Long courseId){
        Map<String, String>  resultMap=new HashMap<>();

        try {
            if (Objects.nonNull(courseDao) && courseId!=0){
                Course course=new Course();
                BeanUtils.copyProperties(courseDao,course);
                course.setCourseId(courseId);
                course=courseRepository.save(course);
                resultMap.put("courseId",course.getCourseId().toString());
            }
            resultMap.put("status", "success");
        }catch (Exception e){
            log.error("Exception occurred while save the data...", e.getMessage());
            resultMap.put("status", "exception");
        }
        return resultMap;

    }

    public Map<String, String> deleteCourse(Long courseId){
        Map<String, String>  resultMap=new HashMap<>();
        try {
            if (courseId!=0){
                if (courseRepository.findById(courseId).isPresent())
                    courseRepository.deleteById(courseId);
                resultMap.put("courseId",courseId.toString());
            }
            resultMap.put("status", "success");
        }catch (Exception e){
            log.error("Exception occurred while save the data...", e.getMessage());
            resultMap.put("status", "exception");
        }
        return resultMap;

    }

    @Override
    public Map<String, Object> getAuthorsById( Long authorId) {
        Map<String, Object> resumtMap=new HashMap<>();
        try {
            Author author=authorProxy.getAuthorsById(authorId);
            List<Course> courses= courseRepository.getByAuthorId(authorId);
            resumtMap.put("author",author);
            resumtMap.put("courses",courses);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resumtMap;
    }


    public Map<String, Object> getAuthors(int page, int size) {

            return authorProxy.getCourses(page,size);


    }
}

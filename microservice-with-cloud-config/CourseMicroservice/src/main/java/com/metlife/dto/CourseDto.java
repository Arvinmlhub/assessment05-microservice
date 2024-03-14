package com.metlife.dto;

import com.metlife.entity.Course;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class CourseDto implements Serializable {

    private List<Course> courseList;

    private Long count;

}

package com.metlife;

import lombok.Data;

import java.io.Serializable;


@Data
public class CourseDao implements Serializable {
    private String courseName;
    private Long authorId;
    private Long duration;
    private Boolean availability=false;
}

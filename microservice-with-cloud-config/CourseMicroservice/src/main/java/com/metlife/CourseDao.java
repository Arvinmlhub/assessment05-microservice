package com.metlife;

import lombok.Data;

import java.io.Serializable;


@Data
public class CourseDao implements Serializable {
    private String courseName;
    private String authorName;
    private Long duration;
    private Boolean availability=false;
}

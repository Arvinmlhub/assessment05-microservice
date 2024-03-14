package com.metlife.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(schema = "VLSDB", name = "course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;

    private String courseName;


    private Long authorId;

private Long duration;


    private Boolean availability=false;


}

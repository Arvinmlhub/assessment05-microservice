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
//
//    @Min(value = 5, message = "Value must be between 5 and 50")
//    @Max(value = 50, message = "Value must be between 5 and 50")
////@Pattern(regexp = "^(?:[5-9]|(?:[1-4][0-9])|50)$", message = "Value must be between 5 and 50")

private Long duration;


    private Boolean availability=false;


}

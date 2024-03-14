package com.metlife.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Author implements Serializable {

    private Long id;
    private String name;
    private String email;

}

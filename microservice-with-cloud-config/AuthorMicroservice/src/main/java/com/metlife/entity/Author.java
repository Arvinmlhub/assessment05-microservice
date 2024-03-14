package com.metlife.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data

@Entity

public class Author  implements Serializable {
    @Id
    private Long id;
    private String name;


    private String email;



}

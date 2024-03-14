package com.metlife.dao;

import lombok.Data;

import java.io.Serializable;


@Data
public class AuthorDao implements Serializable {
    private String id;
    private String author;
    private String email;
}

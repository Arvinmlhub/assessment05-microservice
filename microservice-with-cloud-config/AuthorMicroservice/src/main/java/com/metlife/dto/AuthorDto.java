package com.metlife.dto;

import com.metlife.entity.Author;
import lombok.Data;

import java.util.List;
@Data
public class AuthorDto {
    private Long count;

    private List<Author> authors;
}

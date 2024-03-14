package com.metlife.service;

import com.metlife.dao.AuthorDao;
import com.metlife.dto.AuthorDto;

import java.util.Map;

public interface AuthorService {
    AuthorDto getAuthors(int page , int size);
    Map<String, String> saveAuthor(AuthorDao authorDao);

    Map<String, String> updateAuthor(AuthorDao authorDao, Long authorId);

    Map<String, String> deleteAuthor(Long authorId);
}

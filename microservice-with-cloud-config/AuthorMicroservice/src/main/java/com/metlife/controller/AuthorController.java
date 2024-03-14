package com.metlife.controller;


import com.metlife.dao.AuthorDao;
import com.metlife.dto.AuthorDto;
import com.metlife.entity.Author;
import com.metlife.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping
    public AuthorDto getCourses(@RequestParam(defaultValue = "0",required = false) int page,
                                @RequestParam(defaultValue = "10", required = false) int size){
        return authorService.getAuthors(page,size);
    }

    @PostMapping
    public Map<String, String> saveAuthor(@RequestBody AuthorDao courseDao){
        return authorService.saveAuthor(courseDao);
    }

    @PutMapping("/{authorId}")
    public Map<String, String> updateAuthor(@RequestBody AuthorDao courseDao, @PathVariable Long authorId){
        return authorService.updateAuthor(courseDao,authorId);
    }

    @DeleteMapping("/{authorId}")
    public Map<String, String> deleteAuthor(@PathVariable Long authorId){
        return authorService.deleteAuthor(authorId);
    }

    @GetMapping("/{authorId}")
    public Author getAuthorsById(@PathVariable Long authorId){
        return authorService.getAuthorsById(authorId);
    }



}

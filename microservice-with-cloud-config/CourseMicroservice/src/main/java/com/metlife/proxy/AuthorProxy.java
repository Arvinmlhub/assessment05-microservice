package com.metlife.proxy;

import com.metlife.entity.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "Author-MS", url = "http://localhost:2020")
public interface AuthorProxy {
    @GetMapping("/api/v1/author/{authorId}")
    public Author getAuthorsById(@PathVariable Long authorId);

    @GetMapping("/api/v1/author")
    Map<String, Object> getCourses(@RequestParam(defaultValue = "0", required = false) int page, @RequestParam(defaultValue = "10", required = false) int size);


}

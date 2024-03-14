package com.metlife.service.impl;

import com.metlife.dao.AuthorDao;
import com.metlife.dto.AuthorDto;
import com.metlife.entity.Author;
import com.metlife.repo.AuthorRepo;
import com.metlife.repo.AuthorRepository;
import com.metlife.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService {

        @Autowired
        private AuthorRepo authorRepo;

        @Autowired
        private AuthorRepository authorRepository;
    @Override
    public Map<String, Object> getAuthors(int page, int size) {
        Map<String, Object> resultMap=new HashMap<>();

        AuthorDto authorDto=new AuthorDto();

        try{
            Page<Author> authors= authorRepo.findAll(PageRequest.of(page,size));
            authorDto.setCount(authors.getTotalElements());
            authorDto.setAuthors(authors.getContent());
            resultMap.put("data",authorDto);

        }catch (Exception e){
            log.error("Exception occurred while getting courses.. ");
        }
        return resultMap;

    }

    public Map<String, String> saveAuthor(AuthorDao authorDao) {
        Map<String, String>  resultMap=new HashMap<>();
//
        try {
            if (Objects.nonNull(authorDao)){
                Author author=new Author();
                BeanUtils.copyProperties(authorDao,author);
                author=authorRepository.save(author);
                resultMap.put("courseId",author.getId().toString());
            }

            resultMap.put("status", "success");
        }catch (Exception e){
            log.error("Exception occurred while save the data...", e.getMessage());
            resultMap.put("status", "exception");
            e.printStackTrace();
        }
        return resultMap;

    }
    @Override
    public Map<String, String> updateAuthor(AuthorDao authorDao, Long authorId) {
        Map<String, String>  resultMap=new HashMap<>();

        try {
            if (Objects.nonNull(authorDao) && authorId!=0){
                Author author=new Author();
                BeanUtils.copyProperties(authorDao,author);
                author.setId(authorId);
                author=authorRepository.save(author);
                resultMap.put("courseId",author.getId().toString());
            }
            resultMap.put("status", "success");
        }catch (Exception e){
            log.error("Exception occurred while save the data...", e.getMessage());
            resultMap.put("status", "exception");
        }
        return resultMap;

    }
    @Override
    public Map<String, String> deleteAuthor(Long authorId) {
        Map<String, String>  resultMap=new HashMap<>();
        try {
            if (authorId!=0){
                if (authorRepository.findById(authorId).isPresent())
                    authorRepository.deleteById(authorId);
                resultMap.put("courseId",authorId.toString());
            }
            resultMap.put("status", "success");
        }catch (Exception e){
            log.error("Exception occurred while save the data...", e.getMessage());
            resultMap.put("status", "exception");
        }
        return resultMap;

    }

    @Override
    public Author getAuthorsById(Long authorId){
        Author author=new Author();
        try{
            if (authorId!=0){
                Optional<Author> optionalAuthor= authorRepository.findById(authorId);
                if (optionalAuthor.isPresent())
                    author=optionalAuthor.get();
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return author;

    }
}

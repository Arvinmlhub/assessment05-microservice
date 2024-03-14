package com.metlife.repo;

import com.metlife.entity.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends PagingAndSortingRepository<Author, Long> {
}

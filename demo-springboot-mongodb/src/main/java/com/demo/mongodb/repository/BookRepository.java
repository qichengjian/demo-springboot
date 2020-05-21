package com.demo.mongodb.repository;

import com.demo.mongodb.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author qichengjian
 */
public interface BookRepository extends MongoRepository<Book, Integer> {

    Page<Book> findBooksByName(String name, Pageable pageable);
}

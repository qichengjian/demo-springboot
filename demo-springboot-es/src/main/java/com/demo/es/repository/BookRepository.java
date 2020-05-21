package com.demo.es.repository;

import com.demo.es.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author qichengjian
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

     List<Book> findBooksByTitleLike(String title);
}

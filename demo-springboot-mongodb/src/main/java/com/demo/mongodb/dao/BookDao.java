package com.demo.mongodb.dao;

import com.demo.mongodb.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * @author qichengjian
 */
@Component
public class BookDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(Book book) {
        mongoTemplate.insert(book);
    }

    public Book findByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        Book book = mongoTemplate.findOne(query, Book.class);
        return book;
    }

    public Book updateName(Book book) {
        Query query = new Query(Criteria.where("id").is(book.getId()));
        Update update = new Update().set("name", book.getName());
        mongoTemplate.updateFirst(query, update, Book.class);

        return mongoTemplate.findOne(query, Book.class);
    }

}

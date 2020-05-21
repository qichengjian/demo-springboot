package com.demo.mongodb;

import com.demo.mongodb.dao.BookDao;
import com.demo.mongodb.entity.Book;
import com.demo.mongodb.repository.BookRepository;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MongodbTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void test01() {
        Book book = new Book();
        book.setId(1);
        book.setName("ssss");
        bookDao.save(book);
    }

    @Test
    public void test02() {
        System.out.println(bookDao.findByName("ssss").toString());
    }

    @Test
    public void test03() {
        Book book = new Book();
        book.setId(1);
        book.setName("sssshhhhhhh");
        System.out.println(bookDao.updateName(book));
    }

    @Autowired
    private BookRepository bookRepository;
    @Test
    public void test04() {
        System.out.println(bookRepository.findById(1));

        PageRequest pageRequest = new PageRequest(0, 10);
        Page page = bookRepository.findBooksByName("sssshhhhhhh", pageRequest);
        System.out.println(page);
    }
}

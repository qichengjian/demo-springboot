package com.demo.es;

import com.demo.es.bean.Book;
import com.demo.es.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringDataEsTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void test01() {
        for (int i = 2; i < 5; i++) {
            Book book = new Book();
            book.setId(i);
            book.setName("好书");
            book.setTitle("tttt");
            bookRepository.index(book);
        }
    }

    @Test
    public void test02() {
        List<Book> books = bookRepository.findBooksByTitleLike("t");
        if (books != null && books.size() > 0) {
            books.stream().forEach(t->{
                System.out.println(t.toString());
            });
        }
    }
}

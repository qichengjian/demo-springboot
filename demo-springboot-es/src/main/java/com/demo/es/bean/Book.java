package com.demo.es.bean;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author qichengjian
 */
@Document(indexName = "company", type = "book")
public class Book {

    private Integer id;
    private String name;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

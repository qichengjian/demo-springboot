package com.demo.es;

import com.demo.es.bean.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JestTest {

    @Autowired
    private JestClient jestClient;
    @Test
    public void test01() {
        Article article = new Article();
        article.setId(1);
        article.setName("sss");
        article.setTitle("好消息");

        // 构建一个索引功能
        Index index = new Index.Builder(article).index("company").type("news").build();

        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //测试搜索
    @Test
    public void test02() {
        // 查询表达式
        String json = "{\n" +
                "\t\"query\":{\n" +
                "\t\t\"match\":{\n" +
                "\t\t\t\"title\":\"大\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
        // 构建搜索
        Search search = new Search.Builder(json).addIndex("company").addType("news").build();
        // 执行
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.arkadiusz.migala.simplecrud.integration;

import com.arkadiusz.migala.simplecrud.controller.ArticleController;
import com.arkadiusz.migala.simplecrud.model.ArticleRead;
import com.arkadiusz.migala.simplecrud.model.ArticleWrite;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleCreationTest {

    @Autowired
    private ArticleController articleController;

    @Before
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(articleController);
    }

    @Test
    public void testIfArticleWasCreated() {
        // given
        final String title = "Dummy Title";
        final String content = "Dummy Content";
        final ArticleWrite articleToWrite = new ArticleWrite(title, content);

        // when
        articleController.create(articleToWrite);
        List<ArticleRead> articlesWithGivenTitle = articleController.getAllWithTitle(title);

        // then
        assertFalse(articlesWithGivenTitle.isEmpty());
    }
}

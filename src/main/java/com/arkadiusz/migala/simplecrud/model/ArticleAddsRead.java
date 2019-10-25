package com.arkadiusz.migala.simplecrud.model;

import lombok.Getter;

@Getter
public class ArticleAddsRead extends ArticleRead {
    private final String adds;

    public ArticleAddsRead(ArticleRead article, String adds) {
        super(
            article.getId(),
            article.getTitle(),
            article.getContent()
        );
        this.adds = adds;
    }
}

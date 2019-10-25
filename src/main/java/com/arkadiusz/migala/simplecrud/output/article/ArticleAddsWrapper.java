package com.arkadiusz.migala.simplecrud.output.article;

import com.arkadiusz.migala.simplecrud.model.ArticleAddsRead;
import com.arkadiusz.migala.simplecrud.model.ArticleRead;

public class ArticleAddsWrapper extends ArticleWrapper {
    private final String adds;

    public ArticleAddsWrapper(String adds) {
        this.adds = adds;
    }

    @Override
    public ArticleRead wrap(ArticleRead articleRead) {
        return new ArticleAddsRead(articleRead, adds);
    }
}

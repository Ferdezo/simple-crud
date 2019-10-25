package com.arkadiusz.migala.simplecrud.output.article;

import com.arkadiusz.migala.simplecrud.model.ArticleRead;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@RefreshScope
@Component
public class ArticleAddsOutputProducer implements ArticleOutputProducer {
    private final ArticleWrapper articleWrapper;

    public ArticleAddsOutputProducer(
        @Value("${article.adds.enabled}") boolean addsEnabled,
        @Value("${article.adds.content}") String adds
    ) {
        articleWrapper = addsEnabled ?
            new ArticleAddsWrapper(adds) :
            new ArticleWrapper();
    }

    @Override
    public Collection<ArticleRead> transformAll(Collection<ArticleRead> inputs) {
        return inputs
            .stream()
            .map(this::transform)
            .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public ArticleRead transform(ArticleRead input) {
        return articleWrapper.wrap(input);
    }
}

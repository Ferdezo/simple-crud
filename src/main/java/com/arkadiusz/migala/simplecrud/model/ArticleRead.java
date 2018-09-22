package com.arkadiusz.migala.simplecrud.model;

import lombok.*;

@Getter
@RequiredArgsConstructor
@ToString
public class ArticleRead {
    private final Long id;
    private final String title;
    private final String content;
}

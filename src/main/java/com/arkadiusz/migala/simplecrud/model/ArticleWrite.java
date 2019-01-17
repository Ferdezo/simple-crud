package com.arkadiusz.migala.simplecrud.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class ArticleWrite {
    @NotNull
    private final String title;
    @NotNull
    private final String content;
}

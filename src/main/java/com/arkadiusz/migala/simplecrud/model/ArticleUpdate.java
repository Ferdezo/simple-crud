package com.arkadiusz.migala.simplecrud.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class ArticleUpdate {
    @NotNull
    private final Long id;
    @NotNull
    private final String content;
}

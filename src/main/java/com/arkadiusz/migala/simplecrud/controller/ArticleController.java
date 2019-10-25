package com.arkadiusz.migala.simplecrud.controller;

import com.arkadiusz.migala.simplecrud.data.ArticleRepository;
import com.arkadiusz.migala.simplecrud.model.ArticleRead;
import com.arkadiusz.migala.simplecrud.model.ArticleUpdate;
import com.arkadiusz.migala.simplecrud.model.ArticleWrite;
import com.arkadiusz.migala.simplecrud.output.article.ArticleOutputProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Log4j2
public class ArticleController {
    private final ArticleRepository repository;
    private final ArticleOutputProducer outputProducer;

    @GetMapping
    public Collection<ArticleRead> getAll() {
        return outputProducer.transformAll(repository.findAll());
    }

    @GetMapping("/{id}")
    public Collection<ArticleRead> getAllWithId(@PathVariable("id") Long id) {
        return outputProducer.transformAll(repository.findById(id));
    }

    @GetMapping(params = "title")
    public Collection<ArticleRead> getAllWithTitle(@RequestParam("title") String title) {
        return outputProducer.transformAll(repository.findByTitle(title));
    }

    @PostMapping
    public void create(@Valid ArticleWrite article) {
        repository.insert(article);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        log.info("Deletion of article with id {}", id);
        repository.delete(id);
    }

    @PutMapping(path = "/{id}")
    public void update(
            @PathVariable("id") Long id,
            @RequestParam String content) {
        log.info("Modification of article with id {}", id);
        repository.updateContent(
                new ArticleUpdate(id, content)
        );
    }
}

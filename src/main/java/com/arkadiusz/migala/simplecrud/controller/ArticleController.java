package com.arkadiusz.migala.simplecrud.controller;

import com.arkadiusz.migala.simplecrud.data.ArticleRepository;
import com.arkadiusz.migala.simplecrud.model.ArticleRead;
import com.arkadiusz.migala.simplecrud.model.ArticleUpdate;
import com.arkadiusz.migala.simplecrud.model.ArticleWrite;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
@Log4j2
public class ArticleController {
    private final ArticleRepository repository;

    @GetMapping
    public List<ArticleRead> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public List<ArticleRead> getAllWithId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping(params = "title")
    public List<ArticleRead> getAllWithTitle(@RequestParam String title) {
        return repository.findByTitle(title);
    }

    @PostMapping
    public void create(@Valid ArticleWrite article) {
        repository.insert(article);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {
        log.info("Deletion of article with id {}", id);
        repository.delete(id);
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @RequestParam String content) {
        log.info("Modification of article with id {}", id);
        repository.updateContent(
                new ArticleUpdate(id, content)
        );
    }
}

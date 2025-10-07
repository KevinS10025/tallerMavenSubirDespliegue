package com.jdc.tecertaller.Rest;

import com.jdc.tecertaller.Entities.Article;
import com.jdc.tecertaller.Service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<Article> getAll() {
        return articleService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getById(@PathVariable Long id) {
        return articleService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public Article create(@RequestBody Article article) {
        return articleService.create(article);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody Article article) {
        try {
            return ResponseEntity.ok(articleService.update(id, article));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        articleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
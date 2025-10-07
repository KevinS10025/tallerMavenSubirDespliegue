package com.jdc.tecertaller.Rest;

import com.jdc.tecertaller.Entities.ArticleTag;
import com.jdc.tecertaller.Service.ArticleTagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article-tags")
public class ArticleTagController {

    private final ArticleTagService articleTagService;

    public ArticleTagController(ArticleTagService articleTagService) {
        this.articleTagService = articleTagService;
    }

    @GetMapping
    public List<ArticleTag> getAll() {
        return articleTagService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleTag> getById(@PathVariable Long id) {
        return articleTagService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ArticleTag create(@RequestBody ArticleTag articleTag) {
        return articleTagService.create(articleTag);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<ArticleTag> update(@PathVariable Long id, @RequestBody ArticleTag articleTag) {
        try {
            return ResponseEntity.ok(articleTagService.update(id, articleTag));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        articleTagService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
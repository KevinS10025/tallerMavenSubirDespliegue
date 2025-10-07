package com.jdc.tecertaller.Service;

import com.jdc.tecertaller.Entities.Article;
import com.jdc.tecertaller.Repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    public Optional<Article> getById(Long id) {
        return articleRepository.findById(id);
    }

    public Article create(Article article) {
        // 👇 asignar el article a cada ArticleTag antes de guardar
        if (article.getTags() != null) {
            article.getTags().forEach(tagRelation -> tagRelation.setArticle(article));
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, Article article) {
        return articleRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(article.getTitle());
                    existing.setBody(article.getBody());
                    existing.setUpdatedAt(article.getUpdatedAt());
                    existing.setDeleted(article.getDeleted());
                    existing.setScore(article.getScore());
                    existing.setUser(article.getUser());
                    existing.setCategory(article.getCategory());

                    // Limpiar tags anteriores y asignar los nuevos
                    if (article.getTags() != null) {
                        existing.getTags().clear(); // 👈 borra los viejos (gracias a orphanRemoval = true)
                        article.getTags().forEach(tagRelation -> tagRelation.setArticle(existing));
                        existing.getTags().addAll(article.getTags());
                    }

                    return articleRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }

    public void delete(Long id) {
        articleRepository.deleteById(id);
    }
}


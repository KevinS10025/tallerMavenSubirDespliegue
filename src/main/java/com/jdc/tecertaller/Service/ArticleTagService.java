package com.jdc.tecertaller.Service;

import com.jdc.tecertaller.Entities.ArticleTag;
import com.jdc.tecertaller.Repository.ArticleTagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleTagService {

    private final ArticleTagRepository articleTagRepository;

    public ArticleTagService(ArticleTagRepository articleTagRepository) {
        this.articleTagRepository = articleTagRepository;
    }

    public List<ArticleTag> getAll() {
        return articleTagRepository.findAll();
    }

    public Optional<ArticleTag> getById(Long id) {
        return articleTagRepository.findById(id);
    }

    public ArticleTag create(ArticleTag articleTag) {
        return articleTagRepository.save(articleTag);
    }

    public ArticleTag update(Long id, ArticleTag articleTag) {
        return articleTagRepository.findById(id)
                .map(existing -> {
                    existing.setArticle(articleTag.getArticle());
                    existing.setTag(articleTag.getTag());
                    return articleTagRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("ArticleTag not found"));
    }

    public void delete(Long id) {
        articleTagRepository.deleteById(id);
    }
}
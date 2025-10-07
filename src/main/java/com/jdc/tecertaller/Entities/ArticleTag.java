package com.jdc.tecertaller.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "article_tag")
@Data
public class ArticleTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Article
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkarticle", nullable = false)
    private Article article;

    // Relación con Tag
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fktag", nullable = false)
    private Tag tag;
}

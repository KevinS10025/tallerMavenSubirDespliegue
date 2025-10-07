package com.jdc.tecertaller.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "articles")
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private Boolean deleted = false;

    private Float score;

    // Relación con User (muchos artículos de un usuario)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkuser", nullable = false)
    private User user;

    // Relación con Comments (un artículo tiene muchos comentarios)
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    // Relación con Categories (un artículo puede tener una categoría)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkcategory")
    private Category category;

    // Relación con ArticleTag (muchos a muchos con Tag)
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticleTag> tags;
}
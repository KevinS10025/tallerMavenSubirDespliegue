package com.jdc.tecertaller.Entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcomment;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdat = LocalDateTime.now();

    // Relación con User
    @ManyToOne
    @JoinColumn(name = "iduser", nullable = false)
    private User user;

    // Relación con Article
    @ManyToOne
    @JoinColumn(name = "idarticle", nullable = false)
    private Article article;
}

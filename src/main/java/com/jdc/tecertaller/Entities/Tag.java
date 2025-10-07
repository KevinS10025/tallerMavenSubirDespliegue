package com.jdc.tecertaller.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tags")
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtag;

    @Column(unique = true, nullable = false)
    private String name;
}

package com.boscov.avaliadorFilmes.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToMany(mappedBy = "generos")
    private Set<Filme> filmes;
}


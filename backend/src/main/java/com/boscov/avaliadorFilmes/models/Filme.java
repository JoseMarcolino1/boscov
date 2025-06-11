package com.boscov.avaliadorFilmes.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "filme")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String diretor;

    @Column(name = "ano_lancamento")
    private Integer anoLancamento;
    private Integer duracao;
    private String produtora;
    private String classificacao;
    @Column(length = 1000)
    private String poster;
    @ManyToMany
    @JoinTable(
            name = "genero_filme",
            joinColumns = @JoinColumn(name = "id_filme"),
            inverseJoinColumns = @JoinColumn(name = "id_genero")
    )
    private Set<Genero> generos;

}

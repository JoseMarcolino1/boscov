package com.boscov.avaliadorFilmes.models.dto;

import lombok.Data;

import java.util.Set;


@Data
public class FilmeOutput {
    private Long id;
    private String nome;
    private String diretor;
    private Integer anoLancamento;
    private Set<GeneroOutput> generos;
    private Integer duracao;
    private String produtora;
    private String classificacao;
    private String poster;

}
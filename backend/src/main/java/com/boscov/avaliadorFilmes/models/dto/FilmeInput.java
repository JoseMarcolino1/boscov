package com.boscov.avaliadorFilmes.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class FilmeInput {
    private String nome;
    private String diretor;
    private Integer anoLancamento;
    private Set<Long> generos;
    private Integer duracao;
    private String produtora;
    private String classificacao;
    private String poster;

}
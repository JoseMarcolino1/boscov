package com.boscov.avaliadorFilmes.models.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FilmeInput {
    private String nome;
    private String diretor;
    private Integer anoLancamento;
    private Long generoId;
    private Integer duracao;
    private String produtora;
    private String classificacao;
    private String poster;

}
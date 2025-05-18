package com.boscov.avaliadorFilmes.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
public class FilmeOutput {
    private Long id;
    private String nome;
    private String diretor;
    private Year anoLancamento;
    private Long generoId;
    private Integer duracao;
    private String produtora;
    private String classificacao;
    private String poster;

}
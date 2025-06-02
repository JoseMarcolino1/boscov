package com.boscov.avaliadorFilmes.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class FilmeInput {
    private String nome;
    private String diretor;
    private Integer anoLancamento;
    private List<Long> generosIds; // IDs dos gêneros selecionados
    private Integer duracao;
    private String produtora;
    private String classificacao;
    private String poster;

}
package com.boscov.avaliadorFilmes.models.dto;

import lombok.Data;

@Data
public class AvaliacaoOutput {
    private Long idUsuario;
    private String nomeUsuario;

    private Long idFilme;
    private String nomeFilme;

    private Double nota;
    private String comentario;
}

package com.boscov.avaliadorFilmes.models.dto;

import lombok.Data;

@Data
public class AvaliacaoInput {
    private Long idUsuario;
    private Long idFilme;
    private Double nota;
    private String comentario;

}

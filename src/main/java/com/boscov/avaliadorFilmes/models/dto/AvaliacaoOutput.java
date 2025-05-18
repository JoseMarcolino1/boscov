package com.boscov.avaliadorFilmes.models.dto;

import lombok.Data;

@Data
public class AvaliacaoOutput {
    private Long idUsuario;
    private Long idFilme;
    private Double nota;
    private String comentario;

}

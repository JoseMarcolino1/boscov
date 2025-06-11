package com.boscov.avaliadorFilmes.models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AvaliacaoInput {
    private Long idUsuario;
    private Long idFilme;
    private Double nota;
    private String comentario;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}

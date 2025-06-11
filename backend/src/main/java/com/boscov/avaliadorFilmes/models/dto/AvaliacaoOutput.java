package com.boscov.avaliadorFilmes.models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AvaliacaoOutput {
    private Long idUsuario;
    private String nomeUsuario;

    private Long idFilme;
    private String nomeFilme;

    private Double nota;
    private String comentario;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
